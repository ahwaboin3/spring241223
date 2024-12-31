import { Typography } from '@mui/material';
import './App.css';
import AppBar from "@mui/material/AppBar"
import Toolbar from "@mui/material/Toolbar"
import Carlist from './components/Carlist';

function App() {
  return (
    <div className="App">
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6">
            Carshop
          </Typography>
        </Toolbar>
      </AppBar>
      <Carlist />
    </div>
  );
}

export default App;
