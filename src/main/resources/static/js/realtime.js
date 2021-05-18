const realtime = (function () {
    let stompClient;

    const connect = () => {
        let url = window.location.href;
        let arr = url.split("/");
        let sockjs = new SockJS(arr[0] + "//" + arr[2] + '/ws');
        stompClient = Stomp.over(sockjs);
        stompClient.connect({}, onConnect, onError);
    }

    const onConnect = () => {
        console.log('connected');
        let productId = window.location.pathname.substr(20, 20);
        stompClient.subscribe(
            "/rt/comment/" + productId,
            onComment
        );
        stompClient.subscribe(
            "/rt/quantity/" + productId,
            onQuantityChange
        );
    }

    const onError = (err) => {
        console.error(err);
    }

    const onComment = (msg) => {
        data = JSON.parse(msg.body);
        let comentBox = $("#comment-box-id");
        comentBox.append($("<div class=\"comentario\">" + "<h3>" + data.usuario + "</h3>" + "<p>" + data.contenido + "</p>"));
    }

    const onQuantityChange = (msg) => {
        console.log(msg);
    }

    const sendComment = (c) => {
        stompClient.send('/app/comment', {}, JSON.stringify(c));
    }

    const sendQuantityChange = () => {
        return stompClient.send('/app/quantity');
    }

    return {
        connect: connect,
        sendComment: sendComment,
        sendQuantityChange: sendQuantityChange,
    }
})();

$(document).ready(function () {
    realtime.connect();
});