import React, { useState } from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import ListEmployeeComponent from './components/ListEmployeeComponent';
import Header from './components/Header';
import Footer from './components/Footer';
import AddEmployee from './components/AddEmployee';


function App() {
  return (
    <main>
      <Router>
        <Header />
        <Routes>
          <Route exact path='/' Component={ListEmployeeComponent}></Route>
          <Route path='/employees' Component={ListEmployeeComponent}></Route>
          <Route path='/employees/new' Component={AddEmployee}></Route>
          <Route path='/employees/:id' Component={AddEmployee}></Route>
        </Routes>
        <Footer />
      </Router>
    </main>
  );
}

export default App;
