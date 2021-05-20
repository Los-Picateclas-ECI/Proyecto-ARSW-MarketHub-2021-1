package edu.escuelaing.arsw.markethub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MarketHubWebController {

	@GetMapping(value = "/inicio")
	public String getIndex() {

		return "index";
	}

	@GetMapping(value = "/productos")
	public String getProducts() {

		return "products";
	}

	@GetMapping(value = "/productos/{categoria}")
	public String getProductsCategories(@PathVariable("categoria") String categoria) {

		return "products-categories";
	}

	@GetMapping(value = "/productos/producto/{id}")
	public String getProducts(@PathVariable("id") Integer id) {

		return "product-details";
	}

	@GetMapping(value = "/cuenta")
	public String getCuenta() {

		return "account";
	}

	@GetMapping(value = "/cuenta/registrar")
	public String getRegistrarCuenta() {

		return "account-registration";
	}

	@GetMapping(value = "/carrito")
	public String getCarrito() {

		return "carrito";
	}

	@GetMapping(value = "/login")
	public String getLogin() {

		return "login";
	}

	@GetMapping(value = "/loginfailed")
	public String failedLogin(Model model) {

		model.addAttribute("error", true);
		return "login";
	}

	@GetMapping(value = "/cuenta/configuracion")
	public String getConfiguracionCuenta() {

		return "account-modification";
	}

	@GetMapping(value = "/pagos/respuesta")
	public String getRespuestaPage() {

		return "responseEpayco";
	}

	@GetMapping(value = "/chat")
	public String getChat() {

		return "chat";
	}

	/*-----------------------------------------------*/
	/*----------- MAPPING DEL ADMIN SOCIO -----------*/
	/*-----------------------------------------------*/
	@GetMapping(value = "/admin/registrar/producto")
	public String productRegistration() {

		return "product-registration";
	}

	@GetMapping(value = "/admin/modificar/producto")
	public String productModification() {

		return "product-modification";
	}

	@GetMapping(value = "/admin/dashboard")
	public String adminDashboard() {

		return "admin-dashboard";
	}

}
