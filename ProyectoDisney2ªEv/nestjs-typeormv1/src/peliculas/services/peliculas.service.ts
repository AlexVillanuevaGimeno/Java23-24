import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Pelicula } from '../entities/pelicula.entity';
import { Repository } from 'typeorm';

@Injectable()
export class PeliculasService {
//como inserto mi repository para que gestione las transacciones
// con base de datos de forma automatica => TYPEORM
constructor(
    @InjectRepository(Pelicula) 
    private peliculaRepo: Repository<Pelicula>,
) {}
async findAll(): Promise<Pelicula[]> {
  console.log('Llegando a LISTAR TODOS')
  return this.peliculaRepo.find();
}
  // Nuevo método para filtrar películas por categoría
  async findByCategoria(categoriaId: number): Promise<Pelicula[]> {
    return this.peliculaRepo
      .createQueryBuilder('pelicula')
      .innerJoinAndSelect('pelicula.categorias', 'categoria')
      .where('categoria.id = :categoriaId', { categoriaId })
      .getMany();
  }

}
