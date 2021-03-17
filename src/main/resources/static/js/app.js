const app = (function () {

    let productId = 0;

    const fullStar = "<i class=\"fa fa-star\"></i>";
    const halfStar = "<i class=\"fa fa-star-half-o\"></i>";
    const noStar = "<i class=\"fa fa-star-o\"></i>";


    function getAllProducts() {
        console.log("sadadadassda")
        apiclient().getAllProducts((req, resp) => {
            console.log(resp);
            appendAllProducts(resp);
        });
    }

    function selectPuntIns(data) {
        puntaje = data.puntaje;
        html = "<div class=\"rating\">";
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

    function appendAllProducts(data) {
        for (let i = 0; i < data.length; i++) {
            let puntajeIns = selectPuntIns(data[i]);
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