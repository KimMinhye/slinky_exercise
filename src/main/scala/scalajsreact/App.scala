package scalajsreact

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

import scalajsreact.components._

@react class App extends Component {
  type Props = Unit
  case class State(color: String)

  def initialState = State("#000000")

  def render() = {
    div(
      button(onClick := { _ => handleClick()})("랜덤색상"),
      LifeCycleSample(state.color)
    )
  }

  def handleClick() = {
    setState(State(color = getRandomColor))
  }

  def getRandomColor(): String = {
    "#%06x".format(scala.util.Random.nextInt(1 << 24))
  }
}
