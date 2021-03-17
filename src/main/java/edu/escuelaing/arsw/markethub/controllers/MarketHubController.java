package edu.escuelaing.arsw.markethub.controllers;

import edu.escuelaing.arsw.markethub.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador principal del proyecto MarketHub
 */
@RestController
public class MarketHubController {

    @Autowired
    ProductServices productServices;

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
    public ResponseEntity<?> getProductoById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(productServices.getProductoById(id), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}