import { Pelicula } from "src/peliculas/entities/pelicula.entity";

describe('Pelicula', () => {
  it('should create a movie instance', () => {
    const pelicula = new Pelicula();
    expect(pelicula).toBeDefined();
  });

  it('should set properties correctly', () => {
    const pelicula = new Pelicula();
    pelicula.id = 1;
    pelicula.titulo = 'Movie 1';
    pelicula.descripcion = 'Description of Movie 1';
    pelicula.fecha_lanzamiento = new Date('2024-01-01');
    pelicula.imagen = 'movie1.jpg';
    pelicula.creado_en = new Date('2024-01-01');
    pelicula.categorias = [];
    pelicula.favoritos = [];

    expect(pelicula.id).toEqual(1);
    expect(pelicula.titulo).toEqual('Movie 1');
    expect(pelicula.descripcion).toEqual('Description of Movie 1');
    expect(pelicula.fecha_lanzamiento).toEqual(new Date('2024-01-01'));
    expect(pelicula.imagen).toEqual('movie1.jpg');
    expect(pelicula.creado_en).toEqual(new Date('2024-01-01'));
    expect(pelicula.categorias).toEqual([]);
    expect(pelicula.favoritos).toEqual([]);
  });
});
