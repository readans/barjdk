import jwt from 'jsonwebtoken';
import fs from 'fs';

const secretKey = fs.readFileSync('../keys/secret.key');

export function decrypt(token) {
  return jwt.verify(token, secretKey);
}

export function encrypt(json) {
  return jwt.sign(JSON.stringify(json), secretKey)
}

const jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiZHlsYW4ifQ.ec2vuTDG4hDlAIdqU8JAsPJc3vj7p_rD3OQ2LGEb-TI"
const decrypted = decrypt(jwtToken);

console.log(decrypted);
console.log(encrypt({ iss: 'auth0' }))