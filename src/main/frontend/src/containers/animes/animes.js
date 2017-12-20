import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Button} from 'react-bootstrap';
import './animes.css';
import RestClient from '../../RestClient';
import {AnimeItem} from '../../components/animeItem/animeItem';


export default class Animes extends Component {

    constructor(props) {
        super(props);
        this.state = {
            results: [],
            showModal: false
        };
        this.showMovie = this.showMovie.bind(this);
    }

    componentDidMount() {
        const url = `/api/allMovies`;
        const restClient = RestClient();
        restClient.doGet(url)
            .then(results =>
                this.setState({results})
            );
    }

    // open = () => this.setState({ showModal: true });
    // close = () => this.setState({ showModal: false });


    showMovie() {
        return this.state.results.map((anime, key) =>
            (<Link key={key} to={{pathname: '/anime-detail/' , state: { anime }}}>

                <AnimeItem key={key}
                           title={anime.title}
                           posterImage={anime.posterImage}
                    // rating={movie.rating}
                />

            </Link>)
        );
    }

    render() {
        return (
            <div className="moviesContainer">
                {/* <Button bsStyle="primary" onClick={this.open}> New movie </Button> */}
                {
                    this.showMovie()
                }
            </div>
        );
    }

}

