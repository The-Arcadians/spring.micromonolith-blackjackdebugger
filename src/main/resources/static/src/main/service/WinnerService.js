
class WinnerService {
    constructor(){
        this.headers =  {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        };
    }

    getAllWinners() {

        $.ajax({
            type: "GET",
            crossDomain: true,
            headers: this.headers,
            url: "/winner-controller/read-all",
            dataType: "JSON",
            success: function(response) {
                const json = JSON.stringify(response);
                alert(json);
                return json;
            },
            error: function () {
                        alert('Error while request..');
            }
        });
    }

    getWinnerById(id){
       $.ajax({
           type: "GET",
           crossDomain: true,
           headers: this.headers,
           url: "/winner-controller/read/{id}",
           dataType: 'json',
           success: function(response) {
               const json = JSON.stringify(response);
               alert(json);
               return json;
           },
           error: function () {
                       alert('Error while request..');
           }
       });
    }

    updateWinnerById(id, newWinnerData){
        $.ajax({
           type: "PUT",
           crossDomain: true,
           headers: this.headers,
           url: "/winner-controller/update/{id}",
           data: newWinnerData,
           dataType: 'json',
           success: function(response) {
               const json = JSON.stringify(response);
               alert(json);
               return json;
           },
           error: function () {
                       alert('Error while request..');
           }
       });

    }


}