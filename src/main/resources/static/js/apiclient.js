const apiclient = (function () {

    function getAllProducts(callback) {
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

    function saveProductId(data) {
        console.log(data)
        const promise = $.post({
            url: "/productos/guardar/id",
            contentType: "application/json",
            data: data
        });
    }

    function getProductPageInfo(callback) {
        const promise = $.get({
            url: "/productos/consultar/page",
            contentType: "application/json"
        });
        promise.then(function (data) {
                console.log("apiclient.loadproduct");
                callback(null, data);
            }, function (error) {
                alert("No se pudo realizar la consulta");
            }
        );
    }

    return {
        getAllProducts: getAllProducts,
        saveProductId: saveProductId,
        getProductPageInfo: getProductPageInfo
    }

})();