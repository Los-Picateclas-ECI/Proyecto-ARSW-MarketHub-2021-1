package edu.escuelaing.arsw.markethub.controllers;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import edu.escuelaing.arsw.markethub.entities.CarritoCompra;
import edu.escuelaing.arsw.markethub.entities.Comentario;
import edu.escuelaing.arsw.markethub.entities.Mensaje;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.services.ProductServices;
import edu.escuelaing.arsw.markethub.services.RealTimeServices;

@Controller
public class RealTimeController {
    
    @Autowired private SimpMessagingTemplate messagingTemplate;
    @Autowired private RealTimeServices realTimeServices;
    @Autowired private ProductServices productServices;

    @MessageMapping("/chat")
    public void processMessage(@Payload Mensaje message) {
        realTimeServices.saveMessage(message);
        messagingTemplate.convertAndSendToUser(
            message.getReceptor(), 
            "/mensajes", 
            message);
    }

    @MessageMapping("/comment")
    public void processComment(@Payload Comentario comment) {
        messagingTemplate.convertAndSend(
            "/rt/comment/" + comment.getProducto(), 
            comment);
    }

    @MessageMapping("/quantity")
    public void processQuantity(@AuthenticationPrincipal Principal user) {
        String username = user.getName();
        List<CarritoCompra> carritoCompras = productServices.getCarritoProductsByUsername(username);
        for (CarritoCompra cc : carritoCompras) {
            messagingTemplate.convertAndSend(
                "/rt/quantity/" + cc.getProducto().getId(),
                cc);
        }
    }

    @MessageMapping("/product")
    public void processProduct(@Payload Producto producto) {
        messagingTemplate.convertAndSend(
            "/rt/product/" + producto.getId(), 
            producto);
    }
}
