const app = (function () {

    let puntajeIns = "";
    let productId = 0;

    const rating50 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "</div>";

    const rating45 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-half-o\"></i>" + "</div>";

    const rating40 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating35 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-half-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating30 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating25 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-half-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating20 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating15 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-half-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating10 = "<div class=\"rating\">" + "<i class=\"fa fa-star\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    const rating5 = "<div class=\"rating\">" + "<i class=\"fa fa-star-half-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "<i class=\"fa fa-star-o\"></i>" + "</div>";

    function getAllProducts() {
        console.log("sadadadassda")
        apiclient().getAllProducts((req, resp) => {
            console.log(resp);
            appendAllProducts(resp);
        });
    }

    function selectPuntIns(data) {
        switch (data.puntaje) {
            case 5:
                puntajeIns = rating50;
                break;
            case 4.5:
                puntajeIns = rating45;
                break;
            case 4:
                puntajeIns = rating40;
                break;
            case 3.5:
                puntajeIns = rating35;
                break;
            case 3:
                puntajeIns = rating30;
                break;
            case 2.5:
                puntajeIns = rating25;
                break;
            case 2:
                puntajeIns = rating20;
                break;
            case 1.5:
                puntajeIns = rating15;
                break;
            case 1:
                puntajeIns = rating10;
                break;
            case 0.5:
                puntajeIns = rating5;
                break;
        }
    }

    function appendAllProducts(data) {
        for (let i = 0; i < data.length; i++) {
            selectPuntIns(data[i]);
            $("#container-row__id").append($(
                "<div class=\"container-row__4\" id=\"product" + data[i].id + "\">" +
                "<a id=\"product" + data[i].id + "\" onclick=\"" + "app.saveProductId(this.id)" + "\">" +
                "<img src=" + data[i].imagen[0] + ">" +
                "<h4>" + data[i].nombre + "</h4>" +
                puntajeIns +
                "<p> $" + data[i].precio + "</p>" +
                "</a>" +
                "</div>"
            ));
        }
    }

    function saveProductId(data) {
        console.log(data.substr(7,7))
        productId = data.substr(7,7);
        console.log(productId);
        window.location.href = "/productos/" + productId;
    }

    function loadProductInfo(){
        console.log("cargando producto: " + productId)
    }

    return {
        saveProductId: saveProductId,
        getAllProducts: getAllProducts,
        loadProductInfo: loadProductInfo
    }

})();