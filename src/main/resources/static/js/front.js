const front = (function () {

    function menutoggle() {
        const MenuItems = document.getElementById("MenuItems");
        if (MenuItems.style.maxHeight === "0px") {
            MenuItems.style.maxHeight = "200px";
        } else {
            MenuItems.style.maxHeight = "0px";
        }
    }

    function acctToggle() {
        const AccountItems = document.getElementById("AccountItems");
        if (AccountItems.style.maxHeight === "0px") {
            AccountItems.style.maxHeight = "200px";
        } else {
            AccountItems.style.maxHeight = "0px";
        }
    }

    function loadAll() {
        const promise = new Promise((resolve, reject) => {
            $("#barrita").load("/barrita.html", function () {
                menutoggle();
                acctToggle();
                resolve("Buenardo");
            });
        });
    }

    function changeImages() {
        const productId = window.location.pathname.substr(20, 20);
        loadAll();
        app.loadProductInfo(productId).then(function () {
            const ProductImg = document.getElementById("ProductImg");
            const SmallImg = document.getElementsByClassName("small-img");
            SmallImg[0].onclick = function () {
                ProductImg.src = SmallImg[0].src;
            }
            SmallImg[1].onclick = function () {
                ProductImg.src = SmallImg[1].src;
            }
            SmallImg[2].onclick = function () {
                ProductImg.src = SmallImg[2].src;
            }
            SmallImg[3].onclick = function () {
                ProductImg.src = SmallImg[3].src;
            }
        });
    }

    function loadProducts() {
        loadAll();
        app.getAllProducts();
    }

    function loadCategorias(){
        loadAll();
        app.getAllCategories();
    }

    return {
        menutoggle: menutoggle,
        acctToggle: acctToggle,
        changeImages: changeImages,
        loadProducts: loadProducts,
        loadCategorias: loadCategorias,
        loadAll: loadAll
    };

})();