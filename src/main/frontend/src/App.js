import React, {Component} from 'react';
import Movies from './containers/movies/movies';
import {Route, Switch} from 'react-router-dom';
import {HOME_ROUTE} from './routes';

class App extends Component {
  render() {
    return (
        <Switch>
            <Route exact path={HOME_ROUTE} component={Movies}/>
        </Switch>
    );
  }
}

export default App;
