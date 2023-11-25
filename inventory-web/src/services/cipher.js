import * as jose from 'jose'

const secret = new TextEncoder().encode(
  'OTzANlyFPH+6wcBTiasNRbeqURc9zTsOX1HlocARCOk=',
)

export function decrypt(token) {
  return jose.decodeJwt(token)
}

export async function encrypt(json) {
  const jwt = await new jose.SignJWT(json).setProtectedHeader({ "alg": "HS256" }).sign(secret);
  return jwt;
}