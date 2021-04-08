const app = (function () {
    let productId = 0;

    const fullStar = '<i class="fa fa-star"></i>';
    const halfStar = '<i class="fa fa-star-half-o"></i>';
    const noStar = '<i class="fa fa-star-o"></i>';

    function getAllProducts() {
        apiclient.getAllProducts((req, resp) => {
            appendAllProducts(resp);
        });
    }

    function getStarProducts() {
        apiclient.getStarProducts((req, resp) => {
            appendStartProducts(resp);
        });
    }

    function getLatestProducts(){
        apiclient.getLatestProducts((req, resp) => {
            appedLatestProducts(resp);
        });
    }

    function getAllCategories() {
        apiclient.getAllCategories((req, resp) => {
            appendAllCategoriesOption(resp);
        });
    }

    function selectPuntIns(data) {
        let puntaje = data.puntaje;
        let html = '<div class="rating">';
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

    function appendAllCategoriesOption(data) {
        for (let i = 0; i < data.length; i++) {
            $("#categorias").append($("<option>" + data[i].nombre + "</option>"));
        }
    }

    function appedLatestProducts(data){
        for (let i = 0; i < data.length; i++) {
            let puntajeIns = selectPuntIns(data[i]);
            $("#container-row__ultimos").append(
                $('<div class="container-row__4" id="product' + data[i].id + '">' + '<a id="product' + data[i].id +
                    '" onclick="' + "app.loadProductPage(this.id)" + '">' + "<img src=" + data[i].imagenes[0].url + ">" + "<h4>" +
                    data[i].nombre + "</h4>" + puntajeIns + "<p> $" + data[i].precio + "</p>" + "</a>" + "</div>")
            );
        }
    }

    function appendStartProducts(data) {
        for (let i = 0; i < data.length; i++) {
            let puntajeIns = selectPuntIns(data[i]);
            $("#container-row__star").append(
                $('<div class="container-row__4" id="product' + data[i].id + '">' + '<a id="product' + data[i].id +
                    '" onclick="' + "app.loadProductPage(this.id)" + '">' + "<img src=" + data[i].imagenes[0].url + ">" + "<h4>" +
                    data[i].nombre + "</h4>" + puntajeIns + "<p> $" + data[i].precio + "</p>" + "</a>" + "</div>")
            );
        }
    }

    function appendAllProducts(data) {
        for (let i = 0; i < data.length; i++) {
            let puntajeIns = selectPuntIns(data[i]);
            $("#container-row__id").append(
                $('<div class="container-row__4" id="product' + data[i].id + '">' + '<a id="product' + data[i].id +
                    '" onclick="' + "app.loadProductPage(this.id)" + '">' + "<img src=" + data[i].imagenes[0].url + ">" + "<h4>" +
                    data[i].nombre + "</h4>" + puntajeIns + "<p> $" + data[i].precio + "</p>" + "</a>" + "</div>")
            );
        }
    }

    function appendProductInfo(data) {
        let html =
            '<div class="container-row__2">' +
            '<img id="ProductImg" src="' +
            data.imagenes[0].url +
            '"' +
            'width="100%"' +
            ">" +
            '<div class="small-img-row">';
        for (let i = 1; i < data.imagenes.length; i++) {
            html +=
                '<div class="small-img-col">' +
                '<img class="small-img" src="' +
                data.imagenes[i].url +
                '"' +
                'width="100%"' +
                ">" +
                "</div>";
        }
        html +=
            "</div>" +
            "</div>" +
            '<div class="container-row__2">' +
            "<p>" +
            "Productos / Ropa" +
            "</p>" +
            "<h1>" +
            data.nombre +
            "</h1>" +
            "<h4>" +
            "$ " +
            data.precio +
            "</h4>" +
            '<input type="number" value="' +
            data.cantidad +
            '">' +
            '<a class="container-row__2-btn" href="">Añadir Al Carrito</a>' +
            '<h3>Detalles del Producto <i class="fa fa-indent"></i></h3>' +
            "<br>" +
            "<p>" +
            data.descripcion +
            "</p>" +
            "</div>";

        $("#container-row__detail").append($(html));
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

    function registerProduct() {
        let dataProduct = new FormData($("#formRegistrarProd")[0]);
        $("#reg_prod_submit_btn").prop("disabled", true);
        $("#reg_prod_submit_btn").html('<i class="fas fa-spinner fa-spin"></i>');
        apiclient.registerProduct(dataProduct).then(async (data) => {
            $("#reg_prod_submit_btn").html('<i class="fas fa-check"></i>');
            $("#reg_prod_submit_btn").addClass("success");
            await util.sleep(3000);
            window.location.replace("/productos");
        });
    }

    return {
        loadProductPage: loadProductPage,
        getAllProducts: getAllProducts,
        getStarProducts: getStarProducts,
        getLatestProducts: getLatestProducts,
        loadProductInfo: loadProductInfo,
        registerUser: registerUser,
        getAllCategories: getAllCategories,
        registerProduct: registerProduct,
    };
}

)();
