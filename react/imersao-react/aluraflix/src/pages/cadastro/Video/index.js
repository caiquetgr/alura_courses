import React, { useEffect, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import PageDefault from '../../../components/PageDefault';
import FormField from '../../../components/FormField';
import useForm from '../../../hooks/useForm';
import Button from '../../../components/Button';
import videoRepository from '../../../repositories/videos';
import categoriaRepository from '../../../repositories/categorias';

function CadastroVideo() {
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
    categoriaRepository.getAll()
      .then((categoriasResponse) => {
        setCategorias(categoriasResponse);
      });
  }, []);

  const { values, handleChange } = useForm({
    titulo: 'Padrão',
    url: 'https://www.youtube.com/',
    categoria: 'Front-end',
  });

  const categoryTitles = categorias.map(({ titulo }) => titulo);
  const history = useHistory();

  return (
    <PageDefault>
      <h1>Cadastro de Vídeo</h1>

      <form onSubmit={(event) => {
        event.preventDefault();

        const categoriaEscolhida = categorias
          .find((categoria) => categoria.titulo === values.categoria);

        videoRepository.create({
          titulo: values.titulo,
          url: values.url,
          categoriaId: categoriaEscolhida.id,
        })
          .then(() => history.push('/'));
      }}
      >
        <FormField
          label="Título: "
          type="text"
          name="titulo"
          value={values.titulo}
          onChange={handleChange}
        />

        <FormField
          label="URL: "
          type="text"
          name="url"
          value={values.url}
          onChange={handleChange}
        />
        <FormField
          label="Categoria: "
          name="categoria"
          value={values.categoria}
          onChange={handleChange}
          suggestions={categoryTitles}
        />

        <Button type="submit">
          Cadastrar
        </Button>

      </form>

      <Link to="/cadastro/categoria">
        Cadastrar categoria
      </Link>
    </PageDefault>
  );
}

export default CadastroVideo;
