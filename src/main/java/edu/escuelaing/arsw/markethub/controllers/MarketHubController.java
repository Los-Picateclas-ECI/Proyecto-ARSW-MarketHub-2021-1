package edu.escuelaing.arsw.markethub.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.services.AccountServices;
import edu.escuelaing.arsw.markethub.services.ProductServices;
import edu.escuelaing.arsw.markethub.tools.FileManager;

/**
 * Controlador principal del proyecto MarketHub
 */
@RestController
public class MarketHubController {

    @Autowired
    ProductServices productServices;

    @Autowired
    AccountServices accountServices;

    /**
     * Clase de hello markethub
     *
     * @return - String de bienvenido
     */
    @RequestMapping("/hello")
    public String helloMarketHub() {
        return "Bienvenidos a Markethub";
    }

    /*----------- METODOS GET -----------*/

    @RequestMapping(value = "/productos/consultar", method = RequestMethod.GET)
    public ResponseEntity<?> getProductos() {
        try {
            return new ResponseEntity<>(productServices.getProductos(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductoById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/categorias/consultar", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(productServices.getAllCategories(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*----------- METODOS POST -----------*/

    @RequestMapping(value = "/registrar/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> setProductPageId(@RequestBody UserMH user) {
        try {
            user.setRole(accountServices.getRoleByName("USER"));
            accountServices.registerUser(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
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
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
