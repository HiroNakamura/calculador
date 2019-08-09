const body = document.getElementsByTagName("body")[0];
const h1 = document.getElementsByTagName("h1")[0];
const p1 = document.getElementsByTagName("p")[0];
const principal = document.querySelector("#principal");
var idiomas = "";
var valores = "";
var mensajes = ""; 

function idioma(lang){
    var retorno = '';
    switch(lang){
        case 'es_ES': retorno = "Español";break;
        case 'en_EN': retorno = "Inglés";break;
        case 'de_DE': retorno = "Alemán";break;
        case 'pt_PT': retorno = "Portugues";break;
        case 'fr_FR': retorno = "Franceś";break;
        default: retorno = "No especificado";break;
    }
    return retorno;
}

var Test = {
    init: function(){
        
        fetch('http://localhost:8090/curso/index')
        .then(function(response) {
            return response.text();
        })
        .then(function(texto) {
            h1.textContent = texto.split(";")[1];
            p1.textContent = texto.split(";")[0];
            body.style.backgroundColor = "orange";
        }).catch(function(error){
            h1.textContent = 'Aún no hay conexión';
            p1.textContent = 'Disculpa las molestias';
            body.style.backgroundColor = "gray";
        });  

        fetch("http://localhost:8090/curso/mensajes")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            var cont = 0;
            for(var dato in myJson){
                console.log("Idioma: ",myJson[dato].idioma);
                console.log("Mensaje: ",myJson[dato].mensaje);
                mensajes += "<br/>"+idioma(myJson[dato].idioma)+ "  : "+myJson[dato].mensaje;
                ++cont;
            }
            console.log("Tamaño: "+cont);
            principal.innerHTML = mensajes;
        }).catch(function(error){
            h1.textContent = 'Aún no hay conexión';
            p1.textContent = 'Disculpa las molestias';
        });


        fetch('http://localhost:8090/curso/notas').then(response => response.json())
        .then(notas =>{
            for(var nota in notas){
                console.log('Titulo: ',notas[nota].titulo);
            }
        })
        .catch(e=>{
            console.error("Ha ocurrido un error en el servidor");
        })


    }
};
window.addEventListener("load",Test.init);