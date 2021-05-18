const chat = (function () {
    let stompClient;
    let username;

    const connect = () => {
        let sockjs = new SockJS('http://localhost:8080/ws');
        stompClient = Stomp.over(sockjs);
        stompClient.connect({}, onConnect, onError);
    }

    const onConnect = () => {
        console.log('connected');
        apiclient.getActualUserName((err, res) => {
            username = res;
            stompClient.subscribe(
                "/rt/" + username + "/mensajes",
                onMessage
            );
        });
    }

    const onError = (err) => {
        console.error(err);
    }

    const onMessage = (msg) => {
        console.log(msg);
    }

    const sendMessage = (msg) => {
        let data = {
            emisor: username,
            receptor: "homie.simpson",
            fecha: new Date().toISOString(),
            contenido: msg,
            visto: false
        }
        stompClient.send('/app/chat', {}, JSON.stringify(data));
    }

    return {
        connect: connect,
        sendMessage: sendMessage,
    }
})();

$(document).ready(function () {
    chat.connect();
});