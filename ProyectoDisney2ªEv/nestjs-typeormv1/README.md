<p align="center">
  <a href="http://nestjs.com/" target="blank"><img src="https://nestjs.com/img/logo_text.svg" width="320" alt="Nest Logo" /></a>
</p>

[circleci-image]: https://img.shields.io/circleci/build/github/nestjs/nest/master?token=abc123def456
[circleci-url]: https://circleci.com/gh/nestjs/nest

  <p align="center">A progressive <a href="http://nodejs.org" target="_blank">Node.js</a> framework for building efficient and scalable server-side applications.</p>
    <p align="center">
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/v/@nestjs/core.svg" alt="NPM Version" /></a>
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/l/@nestjs/core.svg" alt="Package License" /></a>
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/dm/@nestjs/common.svg" alt="NPM Downloads" /></a>
<a href="https://circleci.com/gh/nestjs/nest" target="_blank"><img src="https://img.shields.io/circleci/build/github/nestjs/nest/master" alt="CircleCI" /></a>
<a href="https://coveralls.io/github/nestjs/nest?branch=master" target="_blank"><img src="https://coveralls.io/repos/github/nestjs/nest/badge.svg?branch=master#9" alt="Coverage" /></a>
<a href="https://discord.gg/G7Qnnhy" target="_blank"><img src="https://img.shields.io/badge/discord-online-brightgreen.svg" alt="Discord"/></a>
<a href="https://opencollective.com/nest#backer" target="_blank"><img src="https://opencollective.com/nest/backers/badge.svg" alt="Backers on Open Collective" /></a>
<a href="https://opencollective.com/nest#sponsor" target="_blank"><img src="https://opencollective.com/nest/sponsors/badge.svg" alt="Sponsors on Open Collective" /></a>
  <a href="https://paypal.me/kamilmysliwiec" target="_blank"><img src="https://img.shields.io/badge/Donate-PayPal-ff3f59.svg"/></a>
    <a href="https://opencollective.com/nest#sponsor"  target="_blank"><img src="https://img.shields.io/badge/Support%20us-Open%20Collective-41B883.svg" alt="Support us"></a>
  <a href="https://twitter.com/nestframework" target="_blank"><img src="https://img.shields.io/twitter/follow/nestframework.svg?style=social&label=Follow"></a>
</p>
  <!--[![Backers on Open Collective](https://opencollective.com/nest/backers/badge.svg)](https://opencollective.com/nest#backer)
  [![Sponsors on Open Collective](https://opencollective.com/nest/sponsors/badge.svg)](https://opencollective.com/nest#sponsor)-->

## Description

[Nest](https://github.com/nestjs/nest) framework TypeScript starter repository.

## Installation

```bash
$ npm install
```

## Running the app

```bash
# development
$ npm run start

# watch mode
$ npm run start:dev

# production mode
$ npm run start:prod
```

## Test

```bash
# unit tests
$ npm run test

# e2e tests
$ npm run test:e2e

# test coverage
$ npm run test:cov
```

## Support

Nest is an MIT-licensed open source project. It can grow thanks to the sponsors and support by the amazing backers. If you'd like to join them, please [read more here](https://docs.nestjs.com/support).

## Stay in touch

- Author - [Kamil Myśliwiec](https://kamilmysliwiec.com)
- Website - [https://nestjs.com](https://nestjs.com/)
- Twitter - [@nestframework](https://twitter.com/nestframework)

## License

Nest is [MIT licensed](LICENSE).



## Docker

```bash

# Ve al sitio oficial de Docker.

# Haz clic en "Get Docker" para descargar Docker Desktop para Windows.

# Una vez descargado, ejecuta el instalador Docker Desktop Installer.

# Sigue las instrucciones en pantalla para aceptar la licencia, autorizar la instalación y proceder con la instalación.

# Cuando se te solicite, autoriza a Docker Desktop Installer para realizar cambios en tu dispositivo.

# Haz clic en "Finish" en el cuadro de diálogo de instalación para completar la instalación.

# Docker Desktop se iniciará automáticamente una vez que se complete la instalación. Busca el icono de Docker en la barra de tareas.

# Abre una terminal y ejecuta docker version para verificar que Docker se instaló correctamente. Deberías ver información sobre la versión de Docker que acabas de instalar.

# Después de instalar Docker, puedes proceder a construir la imagen Docker para tu aplicación NestJS. Asegúrate de que tu archivo Dockerfile esté en la raíz de tu proyecto y sigue estos pasos:

# Abre una terminal en la raíz de tu proyecto (donde se encuentra tu archivo Dockerfile).

## Tienes que crear este archivo con nombre Dockerfile y con este contenido:

# Use an official Node runtime as the base image
FROM node:14

# Set the working directory in the container to /app
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install the application dependencies
RUN npm install

# Copy the rest of the application code to the working directory
COPY . .

# Compile the application
RUN npm run build

# Expose port 3000 for the application
EXPOSE 3000

# Define the command to run the application
CMD ["npm", "run", "start:prod"]

# Ejecuta el siguiente comando para construir tu imagen Docker:

$ docker build -t my-nest-app . # El my-ne .st-app es el nombre que esta asignando a su imagen docker que estas construyendo puede ser el nombre que quieras pero mejor algo descriptivo de su app.

# Una vez que la imagen se haya construido con éxito, puedes verificar que esté disponible con el siguiente comando:
docker images

# Si quieres ver detalles específicos de una imagen en particular, puedes usar el comando docker inspect, seguido del nombre o ID de la imagen. Por ejemplo:

docker inspect my-nestjs-app

# Cuando construyes una imagen Docker, puedes asignarle un tag utilizando la opción -t o --tag seguida del nombre de la imagen y el tag que deseas asignar. Por ejemplo:


docker build -t nombre-de-la-imagen:tag .

# Ahora puedes ejecutar tu aplicación en un contenedor Docker con el siguiente comando:

docker run -p 3000:3000 my-nestjs-app

# Implementar Docker Compose.

# Para borrar una imagen Docker, puedes utilizar el comando docker rmi seguido del nombre o el ID de la imagen que deseas eliminar. Aquí tienes la sintaxis básica del comando:

docker rmi nombre-de-la-imagen

# Para detener el contenedor y liberar la imagen para que puedas eliminarla, primero necesitas detener el contenedor con el comando docker stop seguido del ID o del nombre del contenedor. Por ejemplo:

docker stop 62bc138ad617

#Para crear un contenedor en Docker, necesitas utilizar el comando docker run. Este comando te permite crear e iniciar un nuevo contenedor basado en una imagen Docker existente.
# La sintaxis básica del comando docker run es la siguiente:

docker run [opciones] nombre-de-la-imagen [comando]

#Opciones y comando es obligatorio

# Para cambiar el nombre de un contenedor en Docker, puedes utilizar el comando docker rename. La sintaxis básica del comando es la siguiente:

docker rename nombre-actual nuevo-nombre

