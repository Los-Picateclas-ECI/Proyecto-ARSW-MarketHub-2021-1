const app = (function () {

    function login() {
        const cadenaLog = {"usuario": $("#username_id").val(), "password": $("#password_id").val()};
        const promise = $.post({
            url: "/login/verificar",
            data: JSON.stringify(cadenaLog),
            contentType: "application/json"
        });
    }

    return {
        login: login
    }

})();