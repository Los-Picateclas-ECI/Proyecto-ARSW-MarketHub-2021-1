const apiclient = (function () {
    function getAllProducts(callback) {
        const promise = $.get({
            url: "/productos/consultar",
            contentType: "application/json",
        });
        promise.then(
            function (data) {
                callback(null, data);
            },
            function (error) {
                alert("No se pudo realizar la consulta");
            }
        );
    }

    function getAllCategories(callback) {
        const promise = $.get({
            url: "/categorias/consultar",
            contentType: "application/json",
        });
        promise.then(
            function (data) {
                callback(null, data);
            },
            function (error) {
                alert("No se pudo realizar la consulta de categorias");
            }
        );
    }

    function getProductPageInfo(productId, callback) {
        const promise = $.get({
            url: "/productos/consultar/" + productId,
            contentType: "application/json",
        });
        promise.then(
            function (data) {
                callback(null, data);
            },
            function (error) {
                alert("No se pudo realizar la consulta");
            }
        );
    }

    function saveProductId(data) {
        const promise = $.post({
            url: "/productos/guardar/id",
            contentType: "application/json",
            data: data,
        });
    }

    function registerUser(data) {
        const promise = $.post({
            url: "/registrar/usuario",
            contentType: "application/json",
            data: JSON.stringify(data),
        });
    }

    function registerProduct(data) {
        return $.ajax({
            type: "POST",
            url: "/registrar/producto",
            data: data,
            cache: false,
            contentType: false,
            processData: false,
            success: function (response) {
                // alert("Se registró satisfactoriamente el producto");
            },
            error: function (xhr, status, err) {
                alert("Ha ocurrido un error en el servidor");
            },
        });
    }

    return {
        getAllProducts: getAllProducts,
        saveProductId: saveProductId,
        getProductPageInfo: getProductPageInfo,
        registerUser: registerUser,
        getAllCategories: getAllCategories,
        registerProduct: registerProduct,
    };
})();
