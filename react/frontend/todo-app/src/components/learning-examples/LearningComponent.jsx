import FirstComponent from './FirstComponent'
import SecondComponent from './SecondComponent'
import { FifthComponent } from './FirstComponent'
import ThirdComponent from './ThirdComponent'
import LearningJavaScript from './LearningJavaScript'

export default function LearningComponent() {
    return (
      <div className="App">
        {/* My Todo Application */}
        <FirstComponent></FirstComponent>
        <SecondComponent></SecondComponent>
        <ThirdComponent></ThirdComponent>
        <FifthComponent></FifthComponent>
        {/* <FifthComponent></FifthComponent> */}
        <LearningJavaScript></LearningJavaScript>
      </div>
    )
  }