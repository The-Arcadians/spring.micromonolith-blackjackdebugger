class LoginService {
    constructor() {
        this.headers = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        };
    }

    login(name) {
        let result;
        const endpoint = "/login-controller/login/" + name;
        $.ajax({
            type: "PUT",
            crossDomain: true,
            headers: this.headers,
            url: endpoint,
            dataType: "JSON",
            success: function (response) {
                result = JSON.stringify(response);
            },
            error: function () {
                alert('Error while request..');
            }
        });
        return result;
    }
}