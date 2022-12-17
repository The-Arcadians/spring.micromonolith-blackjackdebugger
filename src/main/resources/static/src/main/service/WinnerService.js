class WinnerService {
    constructor() {
        this.headers = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        };
    }

    readAll() {
        let result;
        $.ajax({
            type: "GET",
            crossDomain: true,
            headers: this.headers,
            url: "/winner-controller/read-all",
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

    readById(id) {
        let result;
        const endpoint = "/winner-controller/read/" + id;
        $.ajax({
            type: "GET",
            crossDomain: true,
            headers: this.headers,
            url: endpoint,
            dataType: "JSON",
            success: function (response) {
                result =  JSON.stringify(response);
            },
            error: function () {
                alert('Error while request..');
            }
        });
        return result;
    }

    increment(name) {
        let result;
        const endpoint = "/winner-controller/increment/" + name;
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

    
    updateWinner(id, newWinnerData) {
        let result;
        $.ajax({
            type: "PUT",
            crossDomain: true,
            headers: this.headers,
            url: "/winner-controller/update/" + id,
            data: newWinnerData,
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