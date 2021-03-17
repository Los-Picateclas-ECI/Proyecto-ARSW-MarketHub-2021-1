const apiclient = (function () {

    function getAllProducts (callback) {
        console.log("1")
        const promise = $.get({
            url: "/productos/all",
            contentType: "application/json"
        });
        console.log("2")
        promise.then(function (data) {
                callback(null, data);
            }, function (error) {
                alert("No se pudo realizar la consulta");
            }
        );
        console.log("3")
    }

    return {
        getAllProducts: getAllProducts
    }
});