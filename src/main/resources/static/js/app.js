const app = (function () {

    const rating50 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "</div>";

    const rating45 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-half-o\"></i>" +
        "</div>";

    const rating40 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating35 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-half-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating30 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating25 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-half-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating20 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating15 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-half-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating10 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    const rating5 = "<div class=\"rating\">" +
        "<i class=\"fa fa-star-half-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "<i class=\"fa fa-star-o\"></i>" +
        "</div>";

    function login() {
        const cadenaLog = {"usuario": $("#username_id").val(), "password": $("#password_id").val()};
        const promise = $.post({
            url: "/login/verificar",
            data: JSON.stringify(cadenaLog),
            contentType: "application/json"
        });
    }

    function getAllProducts() {
        apiclient().getAllProducts((req, resp) => {
            console.log(resp);
            appendAllProducts(resp);
        });
    }

    function appendAllProducts(data) {
        for (let i = 0; i < data.length; i++) {
            $("#container-row__id").append($(
                "<div class=\"container-row__4\">" +
                    "<img src=" + data[i].imagen[0] + ">" +
                    "<h4>" + data[i].nombre + "</h4>" +
                    "<p> $" + data[i].precio + "</p>" +
                "</div>"
            ));
        }
    }

    return {
        login: login,
        getAllProducts: getAllProducts
    }

})();