import { BrowserRouter } from "react-router-dom";
import MuiTheme from "./MuiTheme";
import Router from "./Router";

const App = () => {
  return (
    <MuiTheme>
      <BrowserRouter>
        <Router />
      </BrowserRouter>
    </MuiTheme>
  );
};

export default App;
