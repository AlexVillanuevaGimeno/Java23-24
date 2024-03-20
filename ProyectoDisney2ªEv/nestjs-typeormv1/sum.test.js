// sum.test.js
const { suma } = require('./sum');

test('suma funciona correctamente', () => {
  expect(suma(1, 2)).toEqual(3);
});
