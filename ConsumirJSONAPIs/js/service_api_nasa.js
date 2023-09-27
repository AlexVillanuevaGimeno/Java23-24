const apiKey = 'mbWeXAKvkdhxkz9Xza8Wcn5k9et41iesXUevKfyq';
const sol = 1000; // El número de sol que deseas consultar

// URL del API de la NASA
//const apiUrl = `https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=${sol}&api_key=${apiKey}`;
const apiUrl = `js/data.json`;


// Realizar una solicitud GET utilizando Fetch API
fetch(apiUrl)
    .then((response) => {
        if (!response.ok) {
            throw new Error('Error en la solicitud al API');
        }
        return response.json();
    })
    .then((data) => {
        
         document.getElementById("img").src = data.photos[0].img_src;
         document.getElementById("cameraFullName").p = data.photos[0].camera.full_name;
         document.getElementById("earthDate").p = data.photos[0].earth_date;
        console.log(data);
        
        data.photos.forEach(photo => {
            // Crear elementos HTML dinámicamente
        var bloque = document.getElementById("BloquePrincipal");

        // Crear una imagen
        var imagen = document.createElement("img");
        imagen.src = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG"; // Reemplaza con la URL de tu imagen
        bloque.appendChild(imagen);

        // Crear un título
        var titulo = document.createElement("h1");
        titulo.textContent = "Título del bloque";
        bloque.appendChild(titulo);

        // Crear un cuadro de texto
        var cuadroTexto = document.createElement("textarea");
        cuadroTexto.rows = 5;
        cuadroTexto.cols = 30;
        bloque.appendChild(cuadroTexto);

        });

        
    })
    .catch((error) => {
        console.error('Ocurrió un error:', error);
    });