package edu.escuelaing.arsw.markethub.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador principal del proyecto MarketHub
 */
@RestController
@RequestMapping(value = "/markethub")
public class MarketHubController {

    /**
     * Clase de hello markethub
     * @return - String de bienvenido
     */
    @RequestMapping("/hello-markethub")
    public String helloMarketHub() {
        return "Bienvenidos a Markethub";
    }

}
