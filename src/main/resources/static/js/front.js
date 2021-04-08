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
        app.getStarProducts();
        app.loadProductInfo(productId).then(function () {
            const ProductImg = document.getElementById("ProductImg");
            const SmallImg = document.getElementsByClassName("small-img");
            for (let i = 0; i < SmallImg.length; i++) {
                SmallImg[i].onclick = function () {
                    ProductImg.src = SmallImg[i].src;
                };
            }
        });
    }

    function loadHomePage(){
        loadAll();
        app.getStarProducts();
        app.getLatestProducts();
    }

    function loadProductsCategories(){
        loadAll();
        app.getProductsByCategory(window.location.pathname.substr(11));
    }

    function loadProducts() {
        loadAll();
        app.getAllProducts();
    }

    function loadCategorias() {
        loadAll();
        app.getAllCategories();
    }

    return {
        menutoggle: menutoggle,
        acctToggle: acctToggle,
        loadHomePage: loadHomePage,
        changeImages: changeImages,
        loadProducts: loadProducts,
        loadProductsCategories: loadProductsCategories,
        loadCategorias: loadCategorias,
        loadAll: loadAll,
    };
})();
