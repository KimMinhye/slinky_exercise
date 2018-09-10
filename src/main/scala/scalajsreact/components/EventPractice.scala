package scalajsreact.components

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import org.scalajs.dom

@react class EventPractice extends Component {
  type Props = Unit
  case class State(userName: String, message: String)

  def initialState = State("", "")

  val handleChange = (e: dom.raw.Event) => {
    setState(state.copy(message = e.target.asInstanceOf[dom.html.Input].value))
  }

  def handleClick(e : dom.raw.Event) = {
    dom.window.alert(s"${state.userName} : ${state.message}")
    setState(State("", ""))
  }

  def handleKeyPress(e: dom.raw.Event) = 
    if (e.asInstanceOf[dom.raw.KeyboardEvent].key == "Enter") handleClick(e)

  def render = {
    div(
      h1("이벤트 연습"),
      input(
        `type` := "text",
        name := "userName",
        placeholder := "유저명",
        value := { state.userName },
        onChange := { (e) =>
          setState(
            state.copy(userName = e.target.asInstanceOf[dom.html.Input].value))
        }
      ),
      input(
        `type` := "text",
        name := "message",
        placeholder := "아무거나 입력해보세요",
        value := { state.message },
        onChange := handleChange,
        onKeyPress := (e => handleKeyPress(e))
      ),
    button(onClick :=(e => handleClick(e)))("확인")
    )
  }
}
