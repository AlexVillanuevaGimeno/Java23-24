import { Test, TestingModule } from '@nestjs/testing';
import { getRepositoryToken } from '@nestjs/typeorm';
import { Pelicula } from '../src/peliculas/entities/pelicula.entity';
import { PeliculasService } from '../src/peliculas/services/peliculas.service';

describe('PeliculasService', () => {
  let service: PeliculasService;
  let repositoryMock: jest.Mocked<any>;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        PeliculasService,
        {
          provide: getRepositoryToken(Pelicula),
          useFactory: () => ({
            find: jest.fn(),
            create: jest.fn(),
            save: jest.fn(),
            // Puedes agregar más métodos según sea necesario
          }),
        },
      ],
    }).compile();

    service = module.get<PeliculasService>(PeliculasService);
    repositoryMock = module.get(getRepositoryToken(Pelicula));
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });

  it('should return all movies', async () => {
    const mockMovies: Pelicula[] = [
        { 
          id: 1, 
          titulo: 'Movie 1', 
          descripcion: 'Descripción de la película 1',
          fecha_lanzamiento: new Date(),
          imagen: 'imagen1.jpg',
          creado_en: new Date(),
          categorias: [], // Aquí debes incluir las categorías si corresponde
          favoritos: [] // Ajusta según sea necesario
        },
        { 
          id: 2, 
          titulo: 'Movie 2', 
          descripcion: 'Descripción de la película 2',
          fecha_lanzamiento: new Date(),
          imagen: 'imagen2.jpg',
          creado_en: new Date(),
          categorias: [], // Aquí debes incluir las categorías si corresponde
          favoritos: [] // Ajusta según sea necesario
        },
      ];
    
    repositoryMock.find.mockReturnValue(mockMovies);

    const result = await service.findAll();

    expect(result).toEqual(mockMovies);
    expect(repositoryMock.find).toHaveBeenCalled();
  });

  it('should return movies by category', async () => {
    const categoryId = 1;
    const mockMovies: Pelicula[] = [
        { 
          id: 1, 
          titulo: 'Movie 1', 
          descripcion: 'Descripción de la película 1',
          fecha_lanzamiento: new Date(),
          imagen: 'imagen1.jpg',
          creado_en: new Date(),
          categorias: [], // Aquí debes incluir las categorías si corresponde
          favoritos: [] // Ajusta según sea necesario
        },
        { 
          id: 2, 
          titulo: 'Movie 2', 
          descripcion: 'Descripción de la película 2',
          fecha_lanzamiento: new Date(),
          imagen: 'imagen2.jpg',
          creado_en: new Date(),
          categorias: [], // Aquí debes incluir las categorías si corresponde
          favoritos: [] // Ajusta según sea necesario
        },
      ];
      
    repositoryMock.createQueryBuilder.mockReturnValue({
      innerJoinAndSelect: jest.fn().mockReturnThis(),
      where: jest.fn().mockReturnThis(),
      getMany: jest.fn().mockResolvedValue(mockMovies),
    });

    const result = await service.findByCategoria(categoryId);

    expect(result).toEqual(mockMovies);
    expect(repositoryMock.createQueryBuilder().innerJoinAndSelect).toHaveBeenCalledWith('pelicula.categorias', 'categoria');
    expect(repositoryMock.createQueryBuilder().where).toHaveBeenCalledWith('categoria.id = :categoriaId', { categoryId });
    expect(repositoryMock.createQueryBuilder().getMany).toHaveBeenCalled();
  });
});
