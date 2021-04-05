let util = (function () {
    let sleep = function (time) {
        return new Promise((resolve) => setTimeout(resolve, time));
    };

    return {
        sleep: sleep,
    };
})();
