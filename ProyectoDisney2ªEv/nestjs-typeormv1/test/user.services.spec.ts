import { Test, TestingModule } from '@nestjs/testing';
import { UsersService } from '../src/users/services/users.service';
import { ProductsService } from '../src/products/services/products.service';
import { ConfigService } from '@nestjs/config';
import { NotFoundException } from '@nestjs/common';
import { CreateUserDto, UpdateUserDto } from '../src/users/dtos/user.dto';
import { getRepositoryToken } from '@nestjs/typeorm';
import { User } from '../src/users/entities/user.entity';

describe('UsersService', () => {
  let service: UsersService;
  let productsService: ProductsService;
  let configService: ConfigService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        UsersService,
        ProductsService,
        ConfigService,
        { provide: getRepositoryToken(User), useValue: {} },
      ],
    }).compile();

    service = module.get<UsersService>(UsersService);
    productsService = module.get<ProductsService>(ProductsService);
    configService = module.get<ConfigService>(ConfigService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });

  describe('findAll', () => {
    it('should return an array of users', async () => {
      jest.spyOn(productsService, 'findAll').mockResolvedValue([]);

      const result = await service.findAll();
      expect(result).toEqual([]);
    });
  });

  describe('findOne', () => {
    it('should return a user by id', async () => {
      const user = { id: 1, email: 'test@example.com', password: 'password', role: 'admin' };
      jest.spyOn(service, 'findOne').mockResolvedValue(user);

      const result = await service.findOne(1);
      expect(result).toEqual(user);
    });

    it('should throw NotFoundException if user is not found', async () => {
      jest.spyOn(service, 'findOne').mockResolvedValue(undefined);

      await expect(service.findOne(1)).rejects.toThrow(NotFoundException);
    });
  });
});
