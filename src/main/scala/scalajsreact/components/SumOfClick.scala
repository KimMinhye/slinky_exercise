package scalajsreact.components

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

@react class SumOfClick extends Component {
  case class Props(name: String, age: Int)
  case class State(buttonPresses: Int)

  def initialState = State(0)
  def render = {
    div(
      p(s"안녕하세요 제 이름은 ${props.name}입니다."),
      p(s"저는 ${props.age}살 입니다."),
      p(s"숫자 :  ${state.buttonPresses}"),
      button(onClick := (_ => setState(State(state.buttonPresses + 1))))("더하기")
    )
  }
}
