const front = (function () {

    function loadAll() {
        const promise = new Promise((resolve, reject) => {
            $("#barrita").load("../barrita.html", function () {
                menutoggle();
                resolve("Buenardo");
            });
        });
    }

    function menutoggle() {
        const MenuItems = document.getElementById("MenuItems");
        if (MenuItems.style.maxHeight === "0px") {
            MenuItems.style.maxHeight = "200px";
        } else {
            MenuItems.style.maxHeight = "0px";
        }
    }

    function changeImages() {
        console.log("1")
        loadAll();
        console.log("2")
        app.loadProductInfo().then(function () {
            console.log("5")
            const ProductImg = document.getElementById("ProductImg");
            const SmallImg = document.getElementsByClassName("small-img");

            console.log(ProductImg)
            console.log(SmallImg)

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

    return {
        menutoggle: menutoggle,
        changeImages: changeImages,
        loadProducts: loadProducts,
        loadAll: loadAll
    }

})();