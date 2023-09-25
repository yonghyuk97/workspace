import React, { useState,createContext } from 'react';

import './App.css';

import CreateMovie from './CreateMovie';
import MovieList from './Movies';

export const MoviesContext = createContext();

function App() {

  const [Movies, setMovies] = useState([]);


  return (
    <MoviesContext.Provider value={ {setMovies, Movies} }>
      <h1>Create Movie</h1>
      <div>
        <CreateMovie/>
      </div>

      <hr/>

      <MovieList/>
    </MoviesContext.Provider>
  );
}

export default App;
