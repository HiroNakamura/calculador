const h1 = document.getElementsByTagName("h1")[0];
const p1 = document.getElementsByTagName("p")[0];

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
    }
};
window.addEventListener("load",Test.init);