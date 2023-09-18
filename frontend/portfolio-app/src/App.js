import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from './pages/Home';
import Portfolio from './pages/Portfolio';
import ProjectInDepth from './pages/ProjectInDepth';
import Manage from './pages/Manage';
import Contact from "./pages/Contact";
import NoPage from './pages/NoPage';

import 'bootstrap/dist/css/bootstrap.min.css';
import './css/Custom.css';


function App() {
  return (
      <Router>
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route path="/portfolio" exact={true} element={<Portfolio/>}/>
          <Route path="/projects/:projectId" element={<ProjectInDepth/>}/>
          <Route path="/manage" exact={true} element={<Manage/>}/>
          <Route path="/contact" exact={true} element={<Contact/>}/>
          <Route path="*" element={<NoPage/>}/>
        </Routes>
      </Router>
  );
}

export default App;
