import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <form>
        <div class="">
          <label for="username" class="">Username</label>
          <input type="text" class="" id="username" placeholder ="Username" />

        </div>
        <div class="">
          <label for="pwd" class="">Password</label>
          <input type="password" class="" id="pwd" placeholder ="Password"/>
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
      </form>
    </div>
  );
}

export default App;
