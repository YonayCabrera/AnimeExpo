import React, {Component} from 'react';
import {Button} from 'react-bootstrap';
import './animeDetails.css';

export default class AnimeDetails extends Component {
    constructor(props) {
        super(props);
        this.state = props.location.state;
        /*this.state = {
            showModal: false
        };
        this.open = this.open.bind(this);
        this.close = this.close.bind(this);*/
    }

    /*open(){
        this.setState({showModal: true});
    }

    close(){
        this.setState({showModal: false});
    }*/

    render() {

        return (
            <div className="movieDetails">
                <div className="actionButtons">
                    <Button bsStyle="primary"> Edit </Button>
                    <Button bsStyle="warning"> Delete </Button>
                </div>
                <img src={this.state.anime.posterImage} alt="Poster" width="80px" height="auto"/>
                <h4> {this.state.anime.title} </h4>
                <p> {this.state.anime.description} </p>
            </div>
        );
    }
}

