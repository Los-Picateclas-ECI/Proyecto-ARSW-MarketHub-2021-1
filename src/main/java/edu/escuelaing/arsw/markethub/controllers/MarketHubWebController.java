package edu.escuelaing.arsw.markethub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MarketHubWebController {

    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/productos", method = RequestMethod.GET)
    public String getProducts() {
        return "products";
    }

    @RequestMapping(value = "/productos/producto/{id}", method = RequestMethod.GET)
    public String getProducts(@PathVariable("id") Integer id) {
        return "product-details";
    }

    @RequestMapping(value = "/cuenta", method = RequestMethod.GET)
    public String getCuenta() {
        return "account";
    }

    @RequestMapping(value = "/carrito", method = RequestMethod.GET)
    public String getCarrito() {
        return "carrito";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String failedLogin(Model model) {
        model.addAttribute("error", true);
        return "login";
    }

}
