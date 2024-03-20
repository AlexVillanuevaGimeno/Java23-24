const { Test, TestingModule } = require('@nestjs/testing');
const { getRepositoryToken } = require('@nestjs/typeorm');
const { PeliculasController } = require('../src/peliculas/controllers/peliculas.controller');
const { Pelicula } = require('../src/peliculas/entities/pelicula.entity');
const { PeliculasService } = require('../src/peliculas/services/peliculas.service');

describe('PeliculasController', () => {
  let controller;
  let peliculasService;

  beforeEach(() => {
    peliculasService = new PeliculasService(); // Se crea una instancia del servicio
    controller = new PeliculasController(peliculasService); // Se crea una instancia del controlador
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  describe('findAll', () => {
    it('should return an array of movies', async () => {
      const mockMovies = [
        { id: 1, titulo: 'Movie 1', descripcion: 'Description 1', fecha_lanzamiento: new Date(), imagen: 'image1.jpg', creado_en: new Date(), categorias: [], favoritos: [] },
        { id: 2, titulo: 'Movie 2', descripcion: 'Description 2', fecha_lanzamiento: new Date(), imagen: 'image2.jpg', creado_en: new Date(), categorias: [], favoritos: [] },
      ];
      jest.spyOn(peliculasService, 'findAll').mockResolvedValue(mockMovies);

      const result = await controller.findAll();

      expect(result).toBe(mockMovies);
    });
  });

  describe('findByCategoria', () => {
    it('should return an array of movies by category', async () => {
      const mockMovies = [
        { id: 1, titulo: 'Movie 1', descripcion: 'Description 1', fecha_lanzamiento: new Date(), imagen: 'image1.jpg', creado_en: new Date(), categorias: [], favoritos: [] },
        { id: 2, titulo: 'Movie 2', descripcion: 'Description 2', fecha_lanzamiento: new Date(), imagen: 'image2.jpg', creado_en: new Date(), categorias: [], favoritos: [] },
      ];
      const categoryId = 1;
      jest.spyOn(peliculasService, 'findByCategoria').mockResolvedValue(mockMovies);

      const result = await controller.findByCategoria(categoryId);

      expect(result).toBe(mockMovies);
      expect(peliculasService.findByCategoria).toHaveBeenCalledWith(categoryId);
    });
  });
});
