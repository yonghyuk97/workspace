import React, { useState,useContext } from 'react';
import { MoviesContext } from './App';


function CreateMovie(){

    const { Movies, setMovies} = useContext(MoviesContext);

    const [Id, setId] = useState('');

    const [Title, setTitle] = useState('');

    const [Genre, setGenre] = useState('');

    const [Date, setDate] = useState('');

    

    const AddMovie = () => {

        if(Id === '' || Title ==='' || Genre === '' || Date === ''){
        
            alert("하나라도 입력되지 않은 경우 모든 요소를 입력해주세요.");
            return;
        }

        for(let movie of Movies){
            if(Id === movie.Id ){
                alert("중복되는 ID는 입력될 수 없습니다.");
                return;
            }
        }

        const newMovie = { Id : Id, Title : Title, Genre : Genre, Date : Date };

        const newMovies = [...Movies, newMovie];

        setMovies(newMovies);
        setId('');
        setTitle('');
        setGenre('');
        setDate('');
    };


    return(
        <>  
        <div className='createMovieArea'>
            <input type='text' placeholder='input movie id' value={Id} onChange={ e => {setId(e.target.value)}}></input>



            <input type='text' placeholder='input movie title' value={Title} onChange={ e => {setTitle(e.target.value)}}></input>


            
            <input type='text' placeholder='input movie genre' value={Genre} onChange={ e => {setGenre(e.target.value)}}></input>

            출시일 : <input type='date' value={Date} onChange={ e => {setDate(e.target.value)}}/>

            <button className='addBtn' onClick={AddMovie}>Add movie</button>
        </div>
        </>
    )
}

export default CreateMovie;