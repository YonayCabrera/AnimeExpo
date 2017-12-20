import React from 'react';
import './animeItem.css';


export const AnimeItem = props =>
    <div key={props.key} className="movies">
        <h4> {props.title} </h4>
        <img src={props.posterImage} alt="Poster" className="posterImages"/>
        {/* <p> Rating:  {props.rating} </p> */}
    </div>