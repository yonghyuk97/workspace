import React, { useState,useContext } from 'react';
import { MoviesContext } from './App';

function MovieList(){

    const { Movies, setMovies} = useContext(MoviesContext);

    const DeleteMovie = (index) => {

        const newMovies = [...Movies]; 
            
        console.log(...Movies);
        
        newMovies.splice(index,1); 

        setMovies(newMovies);

    };



    return(
        <>
            <h1>Movies</h1>
          
            <table className='moviesTable'>
                <tr>
                    <td>ID</td>
                    <td>TItle</td>
                    <td>Genre</td>
                    <td>Release Date</td>
                    <td>Action</td>
                </tr>
                {Movies.map((movie,index) => (
                    <tr>
                        <td>{movie.Id}</td>
                        <td>{movie.Title}</td>
                        <td>{movie.Genre}</td>
                        <td>{movie.Date}</td>
                        <td><button onClick={ ()=> { DeleteMovie(index) }}>Delete</button></td>
                    </tr>
                ))}
            </table>

        </>
    );
}

export default MovieList;