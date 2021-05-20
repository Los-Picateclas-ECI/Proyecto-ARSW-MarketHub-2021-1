const realtime = (function () {
    let stompClient;

    const init = () => {
        let url = window.location.href;
        let arr = url.split("/");
        let sockjs = new SockJS(arr[0] + "//" + arr[2] + '/ws');
        stompClient = Stomp.over(sockjs);
    }

    const connect = () => {
        init();
        stompClient.connect({}, onConnect, onError);
    }

    const connectAndListenProduct = () => {
        init();
        stompClient.connect({}, subscribeProduct, onError);
    }

    const onConnect = () => { }

    const subscribeProduct = () => {
        let productId = window.location.pathname.substr(20, 20);
        stompClient.subscribe(
            "/rt/comment/" + productId,
            onComment
        );
        stompClient.subscribe(
            "/rt/quantity/" + productId,
            onQuantityChange
        );
        stompClient.subscribe(
            "/rt/product/" + productId,
            onProductChange
        );
    }

    const onError = (err) => {
        console.error(err);
    }

    const onComment = (msg) => {
        data = JSON.parse(msg.body);
        let comentBox = $("#comment-box-id");
        comentBox.append($("<div class=\"comentario\">" + "<h3>" + data.usuario + "</h3>" + "<p>" + data.contenido + "</p>"));
    }

    const onQuantityChange = (msg) => {
        let json = JSON.parse(msg.body);
        let cant = $("#ProdID" + json.producto.id);
        let max = cant.attr("max") - json.cantidad;
        let value = cant.attr("value");
        cant.attr({
            "max": max
        });
        if (value > max) {
            cant.attr({
                "value": max
            });
        }
    }

    const onProductChange = (msg) => {
        let json = JSON.parse(msg.body);
        let nombre = json.nombre;
        let precio = json.precio;
        let cantidadEntrada = json.cantidad;
        let cant = $("#ProdID" + json.id);
        let cantvalue = cant.attr("value");
        let descripcion = json.descripcion;
        $("#prodnombre").html(nombre);
        $("#prodprecio").html(precio);
        $("#proddescr").html(descripcion);
        cant.attr({
            "max": cantidadEntrada
        });
        if (cantvalue > cantidadEntrada) {
            cant.attr({
                "value": cantidadEntrada
            });
        }
    }

    const sendComment = (c) => {
        stompClient.send('/app/comment', {}, JSON.stringify(c));
    }

    const sendQuantityChange = () => {
        return stompClient.send('/app/quantity');
    }

    const sendProductUpdate = (p) => {
        stompClient.send('/app/product', {}, JSON.stringify(p));
    }

    return {
        connect: connect,
        connectAndListenProduct: connectAndListenProduct,
        sendComment: sendComment,
        sendQuantityChange: sendQuantityChange,
        sendProductUpdate: sendProductUpdate,
    }
})();
