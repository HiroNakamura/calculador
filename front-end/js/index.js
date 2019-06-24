const h1 = document.getElementsByTagName("h1")[0];
const p1 = document.getElementsByTagName("p")[0];
const principal = document.querySelector("#principal");
var idiomas = "";
var valores = "";
var mensajes = ""; 

var Test = {
    init: function(){
        
        fetch('http://localhost:8090/curso/index')
        .then(function(response) {
            return response.text();
        })
        .then(function(texto) {
            h1.textContent = texto.split(";")[1];
            p1.textContent = texto.split(";")[0]
        });  

        fetch("http://localhost:8090/curso/mensajes")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            for(var dato in myJson){
                console.log("Idioma: ",myJson[dato].idioma);
                console.log("Mensaje: ",myJson[dato].mensaje);
                mensajes += "<br/>"+myJson[dato].idioma+ "  : "+myJson[dato].mensaje;
            }
            principal.innerHTML = mensajes;
        });


    }
};
window.addEventListener("load",Test.init);