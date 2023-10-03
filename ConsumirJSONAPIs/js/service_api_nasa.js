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
        printar(data);   
    })
    .catch((error) => {
        console.error('Ocurrió un error:', error);
    });

    function printar(data) {
        data.photos.forEach(obj => {
          let bloqueFoto = document.createElement("div");
          bloqueFoto.className = "bloqueFoto";
          let img = document.createElement("img");
          img.id = "img"; 
          let detalles = document.createElement("div");
          detalles.className = "detalles";
          let camera = document.createElement("div");
          camera.className = "camera";
          let date = document.createElement("div");
          date.className = "date";
      
          let container = document.getElementById("container");
          container.appendChild(bloqueFoto);
          bloqueFoto.append(img,detalles);
      
          detalles.append(camera,date);
      
          img.src = obj.img_src;
          camera.innerHTML = "Camera: "+ obj.camera.full_name;
          date.innerHTML = "Earth Date: "+obj.earth_date;
      
        });
      }