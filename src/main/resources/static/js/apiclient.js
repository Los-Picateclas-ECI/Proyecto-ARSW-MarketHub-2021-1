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

    function getStarProducts(callback) {
        const promise = $.get({
            url: "/productos/consultar/estrella",
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

    function getLatestProducts(callback) {
        const promise = $.get({
            url: "/productos/consultar/ultimos",
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

    function getProductsByCategory(categoria, callback) {
        const promise = $.get({
            url: "/productos/consultar/categorias/" + categoria,
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

    function getAllCommentsByProductID(producto, callback) {
        const  promise = $.get({
            url: "/comentarios/" + producto,
            contentType: "application/json",
        });
        promise.then(
            function (data) {
                callback(null, data);
            },
            function (error) {
                alert("No se pudieron cargar los comentarios")
            }
        );
    }

    function getActualUserName(callback) {
        const promise = $.get({
            url: "/logged/username",
            contentType: "application/json",
        });
        promise.then(
            function (data) {
                callback(null, data);
            },
            function (error) {
                alert("Es necesario estar loggeado para realizar esta acción.")
            }
        )
    }

    function getCarritoProducts(username, callback) {
        const promise = $.get({
            url: "/carrito-compra/" + username,
            contentType: "application/json",
        });
        promise.then(
            function (data) {
                callback(null, data);
            },
            function (error) {
                alert("No se pudo realizar la consulta! ")
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

    function registerComment(data){
        const promise = $.post({
            url: "/registrar/comentario",
            contentType: "application/json",
            data: JSON.stringify(data),
        });
    }

    function registerProductInToCar(data) {
        const promise = $.post({
            url: "/carrito/registrar/producto",
            contentType: "application/json",
            data: JSON.stringify(data),
        });
    }

    function deleteProductFromCar(data) {
        return $.ajax({
            type: "DELETE",
            url: "/carrito/borrar/" + data,
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
        getProductsByCategory: getProductsByCategory,
        getStarProducts: getStarProducts,
        getLatestProducts: getLatestProducts,
        getProductPageInfo: getProductPageInfo,
        getAllCommentsByProductID: getAllCommentsByProductID,
        getActualUserName: getActualUserName,
        getCarritoProducts: getCarritoProducts,
        saveProductId: saveProductId,
        registerUser: registerUser,
        registerComment: registerComment,
        registerProductInToCar: registerProductInToCar,
        getAllCategories: getAllCategories,
        registerProduct: registerProduct,
        deleteProductFromCar: deleteProductFromCar
    };
})();
