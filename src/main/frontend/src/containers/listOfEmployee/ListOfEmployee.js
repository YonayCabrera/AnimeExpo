import React from 'react';
import {List, ListItem} from 'material-ui/List';
import Divider from 'material-ui/Divider';

const ListOfEmployee = () => (
    <List>
      <ListItem
        primaryText="Brendan Lim"
      />
      <Divider />
      <ListItem
        primaryText="Eric Hoffman"
      />
      <Divider />
      <ListItem
        primaryText="Grace Ng"
      />
      <Divider />
    </List>
);

export default ListOfEmployee;