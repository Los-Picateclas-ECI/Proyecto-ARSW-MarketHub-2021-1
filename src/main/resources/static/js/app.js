const app = (function () {

    let productId = 0;

    const fullStar = "<i class=\"fa fa-star\"></i>";
    const halfStar = "<i class=\"fa fa-star-half-o\"></i>";
    const noStar = "<i class=\"fa fa-star-o\"></i>";


    function getAllProducts() {
        apiclient.getAllProducts((req, resp) => {
            appendAllProducts(resp);
        });
    }

    function getAllCategories(){
        apiclient.getAllCategories((req, resp) => {
            appendAllCategoriesOption(resp);
        });
    }

    function selectPuntIns(data) {
        let puntaje = data.puntaje;
        let html = "<div class=\"rating\">";
        for (let i = 0; i < 5; i++) {
            if (puntaje >= 1) {
                html += fullStar;
                puntaje -= 1;
            } else if (puntaje >= 0.5) {
                html += halfStar;
                puntaje -= 0.5;
            } else {
                html += noStar;
            }
        }
        html += "</div>";
        return html;
    }

    function appendAllCategoriesOption(data){
        for (let i = 0; i < data.length; i++) {
            $("#categorias").append($(
                "<option>" + data[i].nombre +"</option>"
            ));
        }
    }

    function appendAllProducts(data) {
        for (let i = 0; i < data.length; i++) {
            let puntajeIns = selectPuntIns(data[i]);
            $("#container-row__id").append($(
                "<div class=\"container-row__4\" id=\"product" + data[i].id + "\">" +
                "<a id=\"product" + data[i].id + "\" onclick=\"" + "app.loadProductPage(this.id)" + "\">" +
                "<img src=" + data[i].imagenes[0].url + ">" +
                "<h4>" + data[i].nombre + "</h4>" +
                puntajeIns +
                "<p> $" + data[i].precio + "</p>" +
                "</a>" +
                "</div>"
            ));
        }
    }

    function appendProductInfo(data) {
        $("#container-row__detail").append($(
            "<div class=\"container-row__2\">" +
            "<img id=\"ProductImg\" src=\"" + data.imagenes[0].url + "\"" + "width=\"100%\"" + ">" +
            "<div class=\"small-img-row\">" +
            "<div class=\"small-img-col\">" +
            "<img class=\"small-img\" src=\"" + data.imagenes[1].url + "\"" + "width=\"100%\"" + ">" +
            "</div>" +
            "<div class=\"small-img-col\">" +
            "<img class=\"small-img\" src=\"" + data.imagenes[2].url + "\"" + "width=\"100%\"" + ">" +
            "</div>" +
            "<div class=\"small-img-col\">" +
            "<img class=\"small-img\" src=\"" + data.imagenes[3].url + "\"" + "width=\"100%\"" + ">" +
            "</div>" +
            "<div class=\"small-img-col\">" +
            "<img class=\"small-img\" src=\"" + data.imagenes[4].url + "\"" + "width=\"100%\"" + ">" +
            "</div>" +
            "</div>" +
            "</div>" +
            "<div class=\"container-row__2\">" +
            "<p>" + "Productos / Ropa" + "</p>" +
            "<h1>" + data.nombre + "</h1>" +
            "<h4>" + "$ " + data.precio + "</h4>" +
            "<input type=\"number\" value=\"" + data.cantidad + "\">" +
            "<a class=\"container-row__2-btn\" href=\"\">Añadir Al Carrito</a>" +
            "<h3>Detalles del Producto <i class=\"fa fa-indent\"></i></h3>" + "<br>" +
            "<p>" + data.descripcion + "</p>" +
            "</div>"
        ));
    }

    function loadProductPage(data) {
        productId = data.substr(7, 7);
        window.location.href = "/productos/producto/" + productId;
    }

    function loadProductInfo(productId) {
        return new Promise((resolve, reject) => {
            apiclient.getProductPageInfo(productId, (req, resp) => {
                appendProductInfo(resp);
                resolve("Producto Cargado");
            });
        });
    }

    function registerUser() {
        let dataCadenita = {};
        let username = $("#username").val();
        let password = $("#passwd").val();
        let email = $("#mail").val();
        if (username === "" || password === "" || email === "") {
            alert("Debe Ingresar todos los datos");
        } else {
            dataCadenita["username"] = username;
            dataCadenita["password"] = password;
            dataCadenita["email"] = email;
            dataCadenita["role"] = "USER";
            apiclient.registerUser(dataCadenita);
            window.location.href = "/login";
        }
    }

    function registerProduct(){
        let dataProduct = {};
        let nombre = $("#nombre").val();
        let cantidad = $("#cantidad").val();
        let precio = $("#precio").val();
        let descripcion = $("#descripcion").val();
        let categoria = $("#categorias").children("option:selected").val();
        let imagenes = $("#images")[0].files;
        dataProduct["nombre"] = nombre;
        dataProduct["cantidad"] = cantidad;
        dataProduct["precio"] = precio;
        dataProduct["descripcion"] = descripcion;
        dataProduct["categoria"] = categoria;
        dataProduct["imagenes"] = imagenes;
        console.log(dataProduct)
        apiclient.registerProduct(dataProduct)
    }

    return {
        loadProductPage: loadProductPage,
        getAllProducts: getAllProducts,
        loadProductInfo: loadProductInfo,
        registerUser: registerUser,
        getAllCategories: getAllCategories,
        registerProduct: registerProduct
    };

})();