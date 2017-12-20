import React, {Component} from 'react';
import Movies from './containers/animes/animes';
import AnimeDetail from './containers/animeDetails/animeDetails';
import Header from './components/header/header';
import {Route, Switch} from 'react-router-dom';
import {HOME_ROUTE, ANIME_ROUTE, ANIME_DETAIL_ROUTE} from './routes';

class App extends Component {
  render() {
    return (
        <div>
            <Header />
                <Switch>
                    <Route exact path={HOME_ROUTE} component={Movies}/>
                    <Route exact path={ANIME_ROUTE} component={Movies}/>
                    <Route exact path={ANIME_DETAIL_ROUTE} component={AnimeDetail}/>
                </Switch>
        </div>
    );
  }
}

export default App;
