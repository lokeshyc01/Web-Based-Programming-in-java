import React from 'react'
import { NavLink } from 'react-router-dom'

export default function MainNavBar() {
  return (
    <div>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="collapse navbar-collapse" id="navbarNav">
    <ul className="navbar-nav" >
      <li className="nav-item active">
        <NavLink to="/home">Home </NavLink>
      </li>
      <li className="nav-item">
        <NavLink to="/todo">Todo</NavLink>
      </li>
      <li className="nav-item">
        <NavLink to="/addtodo">AddTodo</NavLink>
      </li>
    </ul>
  </div>
</nav>
</div>
  )
}
