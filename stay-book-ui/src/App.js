import './App.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Navbar from './Components/Navbar';
import Home from "./Pages/Home"
function App() {
  return (
   <Router>
    <Navbar />
    <Switch>
      <Route path='/' exact component={Home}/>
    </Switch>

  </Router>  
  );
}

export default App;
