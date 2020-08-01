import config from '../config';

const URL_VIDEOS = `${config.URL_BACKEND}/videos`;

function create(video) {
  return fetch(URL_VIDEOS, {
    method: 'POST',
    headers: {
      'Content-type': 'application/json',
    },
    body: JSON.stringify(video),
  })
    .then(async (resposta) => {
      if (resposta.ok) {
        const respostaJson = await resposta.json();
        return respostaJson;
      }

      throw new Error(resposta.error());
    });
}

export default {
  create,
};
