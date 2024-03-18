import { validate } from 'class-validator';
import { CreateUserDto, UpdateUserDto } from '../src/users/dtos/user.dto';

describe('CreateUserDto', () => {
  it('should pass validation with valid data', async () => {
    const userDto = new CreateUserDto();
    userDto.email = 'test@example.com';
    userDto.password = 'password';
    userDto.role = 'user';

    const errors = await validate(userDto);
    expect(errors.length).toBe(0);
  });

  it('should fail validation with invalid data', async () => {
    const userDto = new CreateUserDto();
    userDto.email = 'invalid-email';
    userDto.password = '12345'; // Password length less than 6 characters
    userDto.role = ''; // Role is empty

    const errors = await validate(userDto);
    expect(errors.length).toBeGreaterThan(0);
  });
});

describe('UpdateUserDto', () => {
  it('should pass validation with valid data', async () => {
    const userDto = new UpdateUserDto();
    userDto.email = 'test@example.com';
    userDto.role = 'user';

    const errors = await validate(userDto);
    expect(errors.length).toBe(0);
  });

  it('should pass validation with partial data', async () => {
    const userDto = new UpdateUserDto();
    userDto.email = 'test@example.com'; // Partial update, other fields are undefined

    const errors = await validate(userDto);
    expect(errors.length).toBe(0);
  });

  it('should fail validation with invalid data', async () => {
    const userDto = new UpdateUserDto();
    userDto.email = 'invalid-email';

    const errors = await validate(userDto);
    expect(errors.length).toBeGreaterThan(0);
  });
});
