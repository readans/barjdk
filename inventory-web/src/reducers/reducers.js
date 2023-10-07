// reducers.js
const counterReducer = (state = 0, action) => {
  switch (action.type) {
    case 'INCREMENT_COUNTER':
      return state + 1;
    case 'DECREMENT_COUNTER':
      return state - 1;
    default:
      return state;
  }
};

import { combineReducers } from 'redux';

const rootReducer = combineReducers({
  counter: counterReducer,
  // Otros reducers aquí si los tienes
});

export default rootReducer;
