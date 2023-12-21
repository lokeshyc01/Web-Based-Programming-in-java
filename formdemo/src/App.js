import logo from './logo.svg';
import './App.css';
import { useEffect } from 'react';
import toast from 'react-hot-toast';
import MainNavBar from './components/MainNavBar';
import 'react-bootstrap/dist/react-bootstrap'
import { Route, Routes } from 'react-router-dom';
import TodoList from './components/TodoList';
import AddTodo from './components/AddTodo';
import Home from './components/Home';
// Put any other imports below so that CSS from your
// components takes precedence over default styles.
function App() {
  useEffect(()=>{
    toast.success("Welcome to Demo Form App!!!");
  },[])
  return (
    <div className="App">

      <h1>Jay Ganesh...</h1>
      <MainNavBar/>

      <Routes>
          <Route path='/home' element={<Home/>}></Route>
          <Route path='/todo' element={<TodoList/>}></Route>
          <Route path='/addtodo' element={<AddTodo/>}></Route>

      </Routes>
    </div>
  );
}

export default App;
