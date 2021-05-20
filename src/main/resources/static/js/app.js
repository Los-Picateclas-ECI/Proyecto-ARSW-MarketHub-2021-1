const app = (function () {
        let productId = 0;
        let total = 0;

        const fullStar = '<i class="fa fa-star"></i>';
        const halfStar = '<i class="fa fa-star-half-o"></i>';
        const noStar = '<i class="fa fa-star-o"></i>';

        function getAllProducts() {
            apiclient.getAllProducts((req, resp) => {
                appendAllProducts(resp);
            });
        }

        function getStarProducts() {
            apiclient.getStarProducts((req, resp) => {
                appendStartProducts(resp);
            });
        }

        function getLatestProducts() {
            apiclient.getLatestProducts((req, resp) => {
                appedLatestProducts(resp);
            });
        }

        function getAllCategories() {
            apiclient.getAllCategories((req, resp) => {
                appendAllCategoriesOption(resp);
            });
        }

        function getProductsByCategory(category) {
            apiclient.getProductsByCategory(category, (req, resp) => {
                appendAllProducts(resp);
                $("#pagetitle__catg").text("Productos / " + resp[0].categoria.nombre);
            });
        }

        function getAllCommentsByProductID(product) {
            apiclient.getAllCommentsByProductID(product, (req, resp) => {
                appendAllComments(resp);
            })
        }

        function getCarritoProducts() {
            apiclient.getActualUserName((req, resp) => {
                apiclient.getCarritoProducts(resp, (req, resp) => {
                    console.log(resp);
                    appendCarritoCompras(resp);
                });
            });
        }

        function selectPuntIns(data) {
            let puntaje = data.puntaje;
            let html = '<div class="rating">';
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

        function appendAllCategoriesOption(data) {
            for (let i = 0; i < data.length; i++) {
                $("#categorias").append($("<option>" + data[i].nombre + "</option>"));
            }
        }

        function appendCarritoCompras(data) {
            $("#carrito-table tbody").empty();
            total = 0;
            for (let i = 0; i < data.length; i++) {
                const subTotal = data[i].cantidad * data[i].producto.precio;
                total += subTotal;
                $("#carrito-table > tbody:last").append(
                    $("<tr id=\"SuperDiv" + data[i].producto.id + "\"><td><div class=\"cart-info\"><a href=\"/productos/producto/" +
                        data[i].producto.id + "\"><img src=\"" + data[i].producto.imagenes[0].url + "\"></a><div><p>" +
                        data[i].producto.nombre + "</p><small> Precio: $" + data[i].producto.precio + "</small><br>" +
                        "<a id=\"" + data[i].producto.id + "\" onclick=\"app.deleteProductFromCar(this.id)\">Eliminar</a></div></div></td><td><p>" +
                        data[i].cantidad + "</p>" + "</td><td><p id=\"PrecioProd" + data[i].producto.id + "\">$" + subTotal + "</p></td></tr>")
                );
            }
            let iva = Math.floor(total * 0.19);
            let totalIva = total + iva;
            $("#total-price-id").append(
                $("<table><tr><td>SubTotal</td><td id=\"totalNoIva\">$" + total + "</td></tr><tr><td>IVA</td><td id=\"ivaAmount\">$" + iva + "</td><tr><td>Total</td><td id=\"totalWithIva\">$" + totalIva + "</td></tr></table>")
            );
        }

        function appendAllComments(data) {
            const comentBox = $("#comment-box-id");
            for (let i = 0; i < data.length; i++) {
                comentBox.append($("<div class=\"comentario\">" + "<h3>" + data[i].usuario + "</h3>" + "<p>" + data[i].contenido + "</p>"));
            }
        }

        function appedLatestProducts(data) {
            for (let i = 0; i < data.length; i++) {
                let puntajeIns = selectPuntIns(data[i]);
                $("#container-row__ultimos").append(
                    $('<div class="container-row__4" id="product' + data[i].id + '">' + '<a id="product' + data[i].id +
                        '" onclick="' + "app.loadProductPage(this.id)" + '">' + "<img src=" + data[i].imagenes[0].url + ">" + "<h4>" +
                        data[i].nombre + "</h4>" + puntajeIns + "<p> $" + data[i].precio + "</p>" + "</a>" + "</div>")
                );
            }
        }

        function appendStartProducts(data) {
            for (let i = 0; i < data.length; i++) {
                let puntajeIns = selectPuntIns(data[i]);
                $("#container-row__star").append(
                    $('<div class="container-row__4" id="product' + data[i].id + '">' + '<a id="product' + data[i].id +
                        '" onclick="' + "app.loadProductPage(this.id)" + '">' + "<img src=" + data[i].imagenes[0].url + ">" + "<h4>" +
                        data[i].nombre + "</h4>" + puntajeIns + "<p> $" + data[i].precio + "</p>" + "</a>" + "</div>")
                );
            }
        }

        function appendAllProducts(data) {
            for (let i = 0; i < data.length; i++) {
                let puntajeIns = selectPuntIns(data[i]);
                $("#container-row__id").append(
                    $('<div class="container-row__4" id="product' + data[i].id + '">' + '<a id="product' + data[i].id +
                        '" onclick="' + "app.loadProductPage(this.id)" + '">' + "<img src=" + data[i].imagenes[0].url + ">" + "<h4>" +
                        data[i].nombre + "</h4>" + puntajeIns + "<p> $" + data[i].precio + "</p>" + "</a>" + "</div>")
                );
            }
        }

        function appendProductInfo(data) {
            let html =
                '<div class="container-row__2">' + '<img id="ProductImg" src="' + data.imagenes[0].url + '"' +
                'width="100%"' + ">" + '<div class="small-img-row">';
            for (let i = 0; i < data.imagenes.length; i++) {
                html += '<div class="small-img-col">' + '<img class="small-img" src="' + data.imagenes[i].url + '"' +
                    'width="100%"' + ">" + "</div>";
            }
            html += "</div>" + "</div>" + '<div class="container-row__2">' + "<p>" + "Productos / " + data.categoria.nombre +
                "</p>" + "<h1>" + data.nombre + "</h1>" + "<h4>" + "$ " + data.precio + "</h4>" + '<input id="ProdID' + data.id + '" type="number"  min="1" value="' +
                data.cantidad + '" max="'+ data.cantidad + '">' + '<a class="container-row__2-btn" onclick="app.registerProductInToCar()">Añadir Al Carrito</a>' + '<h3>Detalles del Producto <i class="fa fa-indent"></i></h3>' +
                "<br>" + "<p>" + data.descripcion + "</p>" + "</div>";
            $("#container-row__detail").append($(html));
        }

        function loadProductPage(data) {
            productId = data.substr(7, 7);
            window.location.href = "/productos/producto/" + productId;
        }

        function loadProductInfo(productId) {
            return new Promise((resolve, reject) => {
                apiclient.getProductPageInfo(productId, (req, resp) => {
                    appendProductInfo(resp);
                    resolve("Producto Cargado");
                });
            });
        }

        function registerPage() {
            window.location.href = "/cuenta/registrar";
        }

        function loadUserInfo() {
            apiclient.getActualUserInfo((req, resp) => {
                appendUserInfo(resp);
            })
        }

        function appendUserInfo(data){
            document.getElementById("username").value = data.username;
            document.getElementById("email").value = data.email;
            document.getElementById("nombre").value = data.nombre;
            document.getElementById("edad").value = data.edad;
            document.getElementById("telefono").value = data.telefono;
            document.getElementById("direccion").value = data.direccion;
            document.getElementById("tipoDoc").value = data.tipodocumento;
            document.getElementById("documento").value = data.documento;
        }

        function registerUser() {
            let dataCadenita = {};
            let username = $("#username").val();
            let nombre = $("#nombre").val();
            let edad = $("#edad").val();
            let email = $("#email").val();
            let telefono = $("#telefono").val();
            let direccion = $("#direccion").val();
            let tipoDocumento = $("#tipoDoc").val();
            let documento = $("#documento").val();
            let password = $("#password").val();
            let passwordConfirm = $("#confirm").val();

            if (username === "" || nombre === "" || edad === "" || telefono === "" || direccion === "" || tipoDocumento === ""
                || documento === "" || password === "" || passwordConfirm === "" || email === "") {
                toastr.error("Debe Ingresar todos los datos");
            } else if (!(password === passwordConfirm)) {
                toastr.error("Las contraseñas no coinciden!");
            } else {
                dataCadenita["username"] = username;
                dataCadenita["documento"] = parseInt(documento);
                dataCadenita["telefono"] = telefono;
                dataCadenita["email"] = email;
                dataCadenita["nombre"] = nombre;
                dataCadenita["edad"] = parseInt(edad);
                dataCadenita["password"] = password;
                dataCadenita["direccion"] = direccion;
                dataCadenita["tipodocumento"] = tipoDocumento;
                apiclient.registerUser(dataCadenita);
                window.location.href = "/login"
            }
        }

        function registerProduct() {
            let dataProduct = new FormData($("#formRegistrarProd")[0]);
            let reg_prod = $("#reg_prod_submit_btn");
            reg_prod.prop("disabled", true);
            reg_prod.html('<i class="fas fa-spinner fa-spin"></i>');
            apiclient.registerProduct(dataProduct).then(async (data) => {
                reg_prod.html('<i class="fas fa-check"></i>');
                reg_prod.addClass("success");
                await util.sleep(3000);
                window.location.replace("/productos");
            });
        }

        function registerComment() {
            const dataCadenita = {};
            const contenido = $("#comment-textarea-id").val();
            const productId = window.location.pathname.substr(20, 20);
            if (contenido === null) {
                toastr.error("Debe escribir algo en la caja de comentarios!")
            } else {
                apiclient.getActualUserName((req, resp) => {
                    dataCadenita["id"] = 0;
                    dataCadenita["usuario"] = resp;
                    dataCadenita["producto"] = parseInt(productId);
                    dataCadenita["contenido"] = contenido;
                    apiclient.registerComment(dataCadenita);
                    realtime.sendComment(dataCadenita);
                    let commentArea = $("#comment-textarea-id");
                    commentArea.val('');
                    // let comentBox = $("#comment-box-id");
                    // comentBox.append($("<div class=\"comentario\">" + "<h3>" + dataCadenita.usuario + "</h3>" + "<p>" + dataCadenita.contenido + "</p>"));
                })
            }
        }

        function registerProductInToCar() {
            const productId = window.location.pathname.substr(20, 20);
            const cantidad = $("#ProdID" + productId).val();
            if (parseInt(cantidad) > 0) {
                apiclient.getActualUserName((req, resp) => {
                    let dataCadenita = {};
                    dataCadenita["usuario"] = resp;
                    apiclient.getProductPageInfo(productId, (req, resp) => {
                        dataCadenita["producto"] = resp;
                        dataCadenita["cantidad"] = cantidad;
                        apiclient.registerProductInToCar(dataCadenita);
                    })
                });
            } else {
                toastr.error("Valor ingresado No Valido!")
            }
        }

        function updateUserAccount(){
            let dataCadenita = {};
            let username = $("#username").val();
            let nombre = $("#nombre").val();
            let edad = $("#edad").val();
            let email = $("#email").val();
            let telefono = $("#telefono").val();
            let direccion = $("#direccion").val();
            let tipoDocumento = $("#tipoDoc").val();
            let documento = $("#documento").val();
            let passwordN = $("#passwordN").val();
            let passwordNConfirm = $("#confirm").val();
            if (passwordN === passwordNConfirm){
                dataCadenita["username"] = username;
                dataCadenita["documento"] = parseInt(documento);
                dataCadenita["telefono"] = telefono;
                dataCadenita["email"] = email;
                dataCadenita["nombre"] = nombre;
                dataCadenita["edad"] = parseInt(edad);
                dataCadenita["password"] = passwordN;
                dataCadenita["direccion"] = direccion;
                dataCadenita["tipodocumento"] = tipoDocumento;
                apiclient.updateUserAccount(dataCadenita);
            } else {
                toastr.error("La nueva contraseña no coincide");
            }
        }

        function deleteProductFromCar(product) {
            let precioS = $("#PrecioProd" + product)[0].outerText;
            let precio = parseInt(precioS.substr(1));
            $("#SuperDiv" + product).remove();
            let totalPrice = $("#total-price-id");
            totalPrice.empty();
            total -= precio;
            let iva = Math.floor(total * 0.19);
            let totalIva = total + iva;
            totalPrice.append(
                $("<table><tr><td>SubTotal</td><td>$" + total + "</td></tr><tr><td>IVA</td><td>$" + iva + "</td><tr><td>Total</td><td>$" + totalIva + "</td></tr></table>")
            );
            apiclient.deleteProductFromCar(product)
        }

        function deleteUser(){
            let dataCadenita = {};
            let username = $("#usernameE").val();
            let passwordEl1 = $("#passwordE").val();
            let passwordEl2 = $("#confirmE").val();
            if (passwordEl1 === passwordEl2){
                dataCadenita["username"] = username;
                dataCadenita["password"] = passwordEl1;
                apiclient.deleteUser(dataCadenita);
            } else {
                toastr.error("Las contraseñas no coinciden");
            }


        }

        return {
            loadProductPage: loadProductPage,
            getAllProducts: getAllProducts,
            getStarProducts: getStarProducts,
            getLatestProducts: getLatestProducts,
            getProductsByCategory: getProductsByCategory,
            getAllCommentsByProductID: getAllCommentsByProductID,
            getCarritoProducts: getCarritoProducts,
            loadProductInfo: loadProductInfo,
            registerProductInToCar: registerProductInToCar,
            registerUser: registerUser,
            registerPage: registerPage,
            registerComment: registerComment,
            getAllCategories: getAllCategories,
            registerProduct: registerProduct,
            loadUserInfo: loadUserInfo,
            updateUserAccount: updateUserAccount,
            deleteProductFromCar: deleteProductFromCar,
            deleteUser: deleteUser
        };
    }

)();
