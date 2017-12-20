import React from 'react';
import { Link } from 'react-router-dom';
import { withRouter } from 'react-router';
import {HOME_ROUTE,ANIME_ROUTE} from '../../routes';
import { Navbar, NavItem, Nav } from 'react-bootstrap';
import './header.css';

export const Header = () =>
  <Navbar inverse collapseOnSelect staticTop>
    <Navbar.Header>
      <Navbar.Brand>
          <Link className="link" to={HOME_ROUTE}>Anime Expo</Link>
      </Navbar.Brand>
      <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
      <Nav>
        <NavItem componentClass="span">
          <Link className="link" to={ANIME_ROUTE}>Animes</Link>
        </NavItem>
      </Nav>
    </Navbar.Collapse>
  </Navbar>
   

export default withRouter(Header)