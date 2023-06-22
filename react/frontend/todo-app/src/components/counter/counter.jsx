import { useState } from 'react'
import './counter.css'
import CounterButton from './counterButton'


export default function Counter(){
    const [count, setCount] = useState(0);

    function incremmentCouterParentFunction(by){
        setCount(count + by)
    }
    function decremmentCouterParentFunction(by){
        setCount(count - by)
    }
    function resetCounter(){
        setCount(0)
    }

    
    return(
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incremmentMethod={incremmentCouterParentFunction} decrementMethod={decremmentCouterParentFunction}/>
            <CounterButton by={2} incremmentMethod={incremmentCouterParentFunction} decrementMethod={decremmentCouterParentFunction}/>
            <CounterButton by={3} incremmentMethod={incremmentCouterParentFunction} decrementMethod={decremmentCouterParentFunction}/>
            <button className="resetButton"
                    onClick={resetCounter}                
                > Reset </button>
        </>
    )

}
