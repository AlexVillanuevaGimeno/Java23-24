//// disney
// import { API_HOST, API_HOST1 } from "../utils/constants";

const API_HOST = "http://192.168.104.76:300";

export async function getPokemonsApi() {
  try {
    const url = `${API_HOST}/peliculas`;
    console.log(url);
    const response = await fetch(url);
    const result = await response.json();
    console.log(result);
    return result;


  } catch (error) {
    throw error;
  }
}