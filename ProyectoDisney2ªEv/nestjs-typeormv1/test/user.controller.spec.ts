import { Test, TestingModule } from '@nestjs/testing';
import { UsersController } from '../src/users/controllers/users.controller';
import { UsersService } from '../src/users/services/users.service';
import { CreateUserDto, UpdateUserDto } from '../src/users/dtos/user.dto';

describe('UsersController', () => {
  let controller: UsersController;
  let userService: UsersService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [UsersController],
      providers: [UsersService],
    }).compile();

    controller = module.get<UsersController>(UsersController);
    userService = module.get<UsersService>(UsersService);
  });

  describe('findAll', () => {
    it('should return an array of users', async () => {
      const result = [{ id: 1, name: 'John Doe' }];
      jest.spyOn(userService, 'getTasks').mockResolvedValue(result);

      expect(await controller.findAll()).toBe(result);
    });
  });

});
