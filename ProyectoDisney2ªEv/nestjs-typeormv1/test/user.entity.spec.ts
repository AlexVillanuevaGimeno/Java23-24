import { User } from '../src/users/entities/user.entity';

describe('User Entity', () => {
  it('should have correct columns', () => {
    const user = new User();
    expect(user).toHaveProperty('id');
    expect(user).toHaveProperty('email');
    expect(user).toHaveProperty('password');
    expect(user).toHaveProperty('role');
    expect(user).toHaveProperty('createAt');
    expect(user).toHaveProperty('updateAt');
    expect(user).toHaveProperty('customer');
    expect(user).toHaveProperty('favoritos');
  });
});
