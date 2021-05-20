const epayco = (function () {

        const handler = ePayco.checkout.configure({
            key: '50e52e87459272185235a103e583ffd6',
            test: true
        });

        const data = {
            //Onpage="false" - Standard="true"
            external: "false",
            //Atributos opcionales
            //response: "https://markethub.tk/pagos/respuesta",
        };

        function epaycoPay() {
            let url = window.location.href;
            let arr = url.split("/");
            data["response"] = arr[0] + "//" + arr[2] + '/pagos/respuesta';
            data["name"] = "Compra MarketHub";
            apiclient.getActualUserName((req, resp) => {
                apiclient.getCarritoProducts(resp, (req, resp) => {
                    let descripcion;
                    descripcion = "Compra: ";
                    for (let i = 0; i < resp.length; i++) {
                        descripcion += resp[i].producto.nombre + " x " + resp[i].cantidad + " ";
                    }
                    data["description"] = descripcion;
                    data["invoice"] = new Date().getMilliseconds();
                    data["currency"] = "cop";
                    // Maximo 200k y Minimo 5k debido a que la cuenta no esta full HD
                    data["amount"] = $("#totalWithIva").text().substr(1);
                    data["tax_base"] = $("#totalNoIva").text().substr(1);
                    data["tax"] = $("#ivaAmount").text().substr(1);
                    data["country"] = "co";
                    data["lang"] = "es";
                    apiclient.getActualUserInfo((req, resp) => {
                        data["name_billing"] = resp.nombre;
                        data["address_billing"] = resp.direccion;
                        data["type_doc_billing"] = resp.tipodocumento;
                        data["mobilephone_billing"] = resp.telefono;
                        data["number_doc_billing"] = resp.documento;
                        handler.open(data);
                    })
                });
            });
        }

        function updateInformation(){
            let estadoTrans = $("#respuesta").text();
            if(estadoTrans === "Aceptada"){
                realtime.sendQuantityChange()
                apiclient.deleteProductExistences();
            }
        }

        return {
            epaycoPay: epaycoPay,
            updateInformation: updateInformation
        };
    }

)();
