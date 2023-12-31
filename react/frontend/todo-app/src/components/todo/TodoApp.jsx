import { useState } from 'react'
import './TodoApp.css'
import { BrowserRouter, Routes, Route, useNavigate, useParams} from 'react-router-dom'
export default function TodoApp(){
    return(
        <div className="TodoApp">
            <BrowserRouter>
            <Routes>
                <Route path = '/' element ={<LoginComponent />}></Route>
                <Route path = '/login' element ={<LoginComponent />}></Route>
                <Route path = '/welcome/:username' element ={<WelcomeComponent />}></Route>
                <Route path = '*' element={<ErrorComponent/>}></Route>
                <Route path = '/listtodos' element={<ListTodosComponent></ListTodosComponent>}></Route>
            </Routes>
            </BrowserRouter>
            
            </div>
            
    )
}

function LoginComponent() {
    const [username, setUsername] = useState('anjali rana')
    const [password, setPassword] = useState('')
    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate();
    function handleUsernameChange(event){
        // console.log(event.target.value);
        setUsername(event.target.value)
    }
    function handlePasswordChange(event){
        setPassword(event.target.value)
    }
    function handleSubmit(){
        if(username === 'anjali rana' && password === 'dummy'){
            console.log('Success');
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
        }
        else{
            console.log('failed');
            setShowErrorMessage(true)
            setShowSuccessMessage(false)
        }
    }
    function SuccessMessageComponent(){
        if(showSuccessMessage){
        return(
            <div className="successMeesage">Authenticated successfully</div>
        )
        }
        return null
    }
    function ErrorMessageComponent(){
        if(showErrorMessage){
        return(
            <div className="errorMeesage">Authenticated failed. Please check your credentials</div>
        )
        }
        return null
    }
    
    return(
        <div className="Login">
            <h1>Time to Login!</h1>
            {showSuccessMessage && <div className="successMeesage">Authenticated successfully</div> }
            {showErrorMessage && <div className="errorMeesage">Authenticated failed. Please check your credentials</div>}
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value = {password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" on onClick={handleSubmit}>Login</button>
                </div>
            </div>
            
        </div>
    )
}


function WelcomeComponent() {
    const {username}  = useParams()
    console.log(username)
    return(
        <div className="WelcomeComponent">
            <h1>Welcome! {username}</h1>
             Welcome Component
        </div>
    )
}
function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>We are working really hard!</h1>
            <div>
                Apologies for the 404, Reach out to our team at ABC
            </div>
        </div>
    )
}
function ListTodosComponent() {
const todos = [
    {id:1, description :'Learn AWS'},
    {id:2, description :'Learn DevOps'},
    {id:3, description :'Learn Full Stack'},
    {id:4, description :'Learn Azure'}
]
return (
    <div className="ErrorComponent">
        <h1>Things You Want To Do!</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <td>id</td>
                        <td>description</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key = {todo.id}>
                                   <td>{todo.id}</td>
                                   <td>{todo.description}</td>
                                </tr>
                            )
                        )
                    }
                    
                </tbody>
            </table>
        </div>
    </div>
)
}