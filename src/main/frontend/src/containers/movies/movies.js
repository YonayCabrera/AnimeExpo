import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Button} from 'react-bootstrap';
import './movies.css';
import RestClient from '../../RestClient';
import {MovieItem} from '../../components/movieItem/movieItem';


class Movies extends Component {

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
        return this.state.results.map((movie, key) =>
                // <Link  key={i} to={{ pathname: `/movies/${movie.id}`, state: { movie } }}>
                <MovieItem key={key}
                           title={movie.title}
                    // poster_image={movie.poster_image}
                    // rating={movie.rating}
                />

            // </Link>
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

export default Movies;
