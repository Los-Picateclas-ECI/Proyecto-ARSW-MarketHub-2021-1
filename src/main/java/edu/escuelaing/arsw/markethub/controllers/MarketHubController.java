package edu.escuelaing.arsw.markethub.controllers;

import edu.escuelaing.arsw.markethub.entities.*;
import edu.escuelaing.arsw.markethub.services.AccountServices;
import edu.escuelaing.arsw.markethub.services.ProductServices;
import edu.escuelaing.arsw.markethub.tools.FileManager;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Controlador principal del proyecto MarketHub
 */
@RestController
public class MarketHubController {

    ProductServices productServices;
    AccountServices accountServices;

    @Autowired
    public MarketHubController(ProductServices productServices, AccountServices accountServices) {
        this.productServices = productServices;
        this.accountServices = accountServices;
    }

    /**
     * Clase de hello markethub
     *
     * @return - String de bienvenido
     */
    @RequestMapping("/hello")
    public String helloMarketHub() {
        return "Bienvenidos a Markethub";
    }

    /*----------- MÉTODOS GET -----------*/

    @RequestMapping(value = "/usuario/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserFullInfo(@PathVariable("username") String username) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String usernameAuth = ((User) auth.getPrincipal()).getUsername();
            if (!usernameAuth.equals(username)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            } else {
                return new ResponseEntity<>(accountServices.getUser(username), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/logged/username", method = RequestMethod.GET)
    public ResponseEntity<?> getUsrInfo() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return new ResponseEntity<>(((User) auth.getPrincipal()).getUsername(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/productos/consultar", method = RequestMethod.GET)
    public ResponseEntity<?> getProductos() {
        try {
            return new ResponseEntity<>(productServices.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductoById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/estrella")
    public ResponseEntity<?> getStarProducts() {
        try {
            return new ResponseEntity<>(productServices.getProductsByRating(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/ultimos")
    public ResponseEntity<?> getLatestProducts() {
        try {
            return new ResponseEntity<>(productServices.getProductsByLatest(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/categorias/{categoria}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProductsByCategory(@PathVariable("categoria") String categoria) {
        try {
            return new ResponseEntity<>(productServices.getProductsByCategory(categoria), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/categorias/consultar", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(productServices.getAllCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/comentarios/{producto}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllComments(@PathVariable("producto") Integer producto) {
        try {
            //.getAllCommentsByProductID
            return new ResponseEntity<>(productServices.getAllCommentsByProductID(producto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/carrito-compra/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getCarritoCompra(@PathVariable String username) {
        try {
            return new ResponseEntity<>(productServices.getCarritoProductsByUsername(username), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    /*----------- MÉTODOS POST -----------*/

    @RequestMapping(value = "/registrar/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> setProductPageId(@RequestBody UserMH user) {
        try {
            user.setRole(accountServices.getRoleByName("USER"));
            accountServices.registerUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/registrar/producto", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> setProductPageId(@ModelAttribute Producto producto,
                                              @RequestPart("categoria_nombre") String categoria_str,
                                              @RequestPart List<MultipartFile> images) {
        try {
            Categoria categoria = productServices.getCategory(categoria_str);
            producto.setCategoria(categoria);
            producto.setPuntaje(3d);

            productServices.insertProduct(producto);

            String tempDir = "temp";
            File dir = FileManager.createDir(tempDir);
            for (MultipartFile mpFile : images) {
                Imagen imagenMH = new Imagen();
                imagenMH.setProductoId(producto.getId());

                String fileName = System.currentTimeMillis() + ".jpg";
                File img = new File(tempDir + File.separator + fileName);

                byte[] bytes = mpFile.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(img));
                stream.write(bytes);
                stream.close();

                productServices.insertImage(img, imagenMH);
            }
            FileManager.removeDir(dir);
            productServices.insertProductCache(producto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/registrar/comentario", method = RequestMethod.POST)
    public ResponseEntity<?> registerComment(@RequestBody Comentario comentario) {
        try {
            productServices.registerComment(comentario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/carrito/registrar/producto", method = RequestMethod.POST)
    public ResponseEntity<?> registerProductInToCar(@RequestBody CarritoCompra carritoCompra) {
        try {
            productServices.insertCarritoCompra(carritoCompra);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /*----------- MÉTODOS DELETE -----------*/

    @RequestMapping(value = "/carrito/borrar/{producto}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProductFromCar(@PathVariable Integer producto) {
        try {
            productServices.deleteProductFromCar(producto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/carrito/borrar/todo", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllFromCar() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            productServices.deleteAllFromCar(auth.getName());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/eliminar/usuario", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestBody String userInfo){
        try {
            JSONObject jsonObject = new JSONObject(userInfo);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String usernameAuth = ((User) auth.getPrincipal()).getUsername();
            if (!usernameAuth.equals(jsonObject.get("username"))){
                return new ResponseEntity<>("Usuario no coincide con el usuario actual", HttpStatus.FORBIDDEN);
            }
            else if (accountServices.deleteUser(jsonObject)){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Contraseña Incorrecta", HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/eliminar/existencias", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProductExistences(){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = ((User) auth.getPrincipal()).getUsername();
            productServices.updateExistenciasWithCarInfo(username);
            this.deleteAllFromCar();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*----------- MÉTODOS PUT -----------*/

    @RequestMapping(value = "/actualizar/usuario", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserAccount(@RequestBody UserMH user) {
        try {
            accountServices.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
