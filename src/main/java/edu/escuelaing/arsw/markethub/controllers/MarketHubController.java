package edu.escuelaing.arsw.markethub.controllers;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.services.AccountServices;
import edu.escuelaing.arsw.markethub.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador principal del proyecto MarketHub
 */
@RestController
public class MarketHubController {

    private static Integer productoPageId = 0;

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

    @RequestMapping(value = "/productos/all", method = RequestMethod.GET)
    public ResponseEntity<?> getProductos() {
        try {
            return new ResponseEntity<>(productServices.getProductos(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductoById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(productServices.getProductoById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/productos/consultar/page", method = RequestMethod.GET)
    public ResponseEntity<?> getProductInfoPage() {
        try {
            return getProductoById(productoPageId);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*----------- METODOS POST -----------*/

    @RequestMapping(value = "/productos/guardar/id", method = RequestMethod.POST)
    public ResponseEntity<?> setProductPageId(@RequestBody Integer id) {
        try {
            productoPageId = id;
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/registrar/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> setProductPageId(@RequestBody UserMH user) {
        try {
            user.setRole("USER");
            accountServices.registerUser(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}