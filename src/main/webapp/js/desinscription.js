/**
 * 
 */
function desinscription() {

    fetch(apiHost+"FAB1/service/utilisateurs/desinscription", {
        method: 'delete',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then(function f(){
        sessionStorage.setItem("isconnected",false);
        location.replace(apiHost+"FAB1")

    })
}