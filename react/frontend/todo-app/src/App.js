// import logo from './logo.svg';
// 
import './App.css';
import Counter from './components/counter/counter';
// import LearningComponent from './components/learning-examples/LearningComponent';
// import Counter  from './components/counter/counter'



function App() {
  return (
    <div className="App">
      {/* <PlayingWithProps property1="value1" property2="value2"></PlayingWithProps> */}
      <Counter></Counter>
    </div>
  )
}


// function PlayingWithProps(properties){
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)
//   return(
//     <div>Props</div>
//   )
// }


//deconstruction method
function PlayingWithProps({property1, property2}){
  
  console.log(property1)
  console.log(property2)
  return(
    <div>Props</div>
  )
}


export default App;
