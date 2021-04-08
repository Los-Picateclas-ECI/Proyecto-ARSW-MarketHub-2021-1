package edu.escuelaing.arsw.markethub.controllers;

import edu.escuelaing.arsw.markethub.entities.*;
import edu.escuelaing.arsw.markethub.services.AccountServices;
import edu.escuelaing.arsw.markethub.services.ProductServices;
import edu.escuelaing.arsw.markethub.tools.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
            return new ResponseEntity<>(productServices.getAllProducts(), HttpStatus.ACCEPTED);
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

    @RequestMapping(value = "/productos/consultar/estrella")
    public ResponseEntity<?> getStarProducts() {
        try {
            return new ResponseEntity<>(productServices.getProductsByRating(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/ultimos")
    public ResponseEntity<?> getLatestProducts() {
        try {
            return new ResponseEntity<>(productServices.getProductsByLatest(), HttpStatus.ACCEPTED);
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
