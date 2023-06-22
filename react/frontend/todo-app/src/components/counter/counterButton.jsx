import {PropTypes} from 'prop-types'
import { useState } from 'react'
export default function CounterButton({by,incremmentMethod,decrementMethod}) {
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

