import { useState } from 'react'
import {PropTypes} from 'prop-types'
import './counter.css'

export default function Counter(){
    const [count, setCount] = useState(0);

    function incremmentCouterParentFunction(by){
        setCount(count + by)
    }
    function decremmentCouterParentFunction(by){
        setCount(count - by)
    }


    
    return(
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incremmentMethod={incremmentCouterParentFunction} decrementMethod={decremmentCouterParentFunction}/>
            <CounterButton by={2} incremmentMethod={incremmentCouterParentFunction} decrementMethod={decremmentCouterParentFunction}/>
            <CounterButton by={3} incremmentMethod={incremmentCouterParentFunction} decrementMethod={decremmentCouterParentFunction}/>
        </>
    )

}
function CounterButton({by,incremmentMethod,decrementMethod}) {
    const [count, setCount] = useState(0);

    
    function incrementCounterFunction(){
        setCount(count + by)
        incremmentMethod(by);
    }
    function decrementCounterFunction(){
        setCount(count - by)
        decrementMethod(by);
    }
    return (
        <div className="Counter">
            
            <div>

            <button className="counterButton"
                    onClick={incrementCounterFunction}                
                
                >+{by}</button>
            
           
            <button className="counterButton2"
                    onClick={decrementCounterFunction}                
                
                >-{by}</button>
                
            </div>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 5
}