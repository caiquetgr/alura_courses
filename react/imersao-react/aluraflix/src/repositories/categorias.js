import config from '../config';

const URL_CATEGORIES = config.URL_BACKEND;

function getAllWithVideos() {
  return fetch(`${URL_CATEGORIES}/categorias?_embed=videos`)
    .then(async (resposta) => {
      if (resposta.ok) {
        const respostaJson = await resposta.json();
        return respostaJson;
      }

      throw new Error(resposta.error());
    });
}

function getAll() {
  return fetch(`${URL_CATEGORIES}/categorias`)
    .then(async (resposta) => {
      if (resposta.ok) {
        const respostaJson = await resposta.json();
        return respostaJson;
      }

      throw new Error(resposta.error());
    });
}

export default {
  getAllWithVideos,
  getAll,
};
