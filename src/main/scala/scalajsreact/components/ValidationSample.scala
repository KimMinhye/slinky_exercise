package scalajsreact.components

import slinky.core._
import slinky.core.facade.React
import slinky.core.annotations.react
import slinky.web.html._

import org.scalajs.dom
import org.scalajs.dom.raw.{Element, HTMLElement, Event}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}

@JSImport("resources/ValidationSample.css", JSImport.Default)
@js.native
object ValidationSampleCSS extends js.Object

@react class ValidationSample extends Component {
  type Props = Unit
  case class State(password: String = "",
                   clicked: Boolean = false,
                   validated: Boolean = false)
  private val css = ValidationSampleCSS
  val inputRef    = React.createRef[Element]

  def initialState = State("", false, false)

  def render = {
    div(
      input(
        ref := inputRef,
        `type` := "password",
        value := { state.password },
        onChange := { handleChange _ },
        className := {
          if (state.clicked) {
            if (state.validated) "success"
            else "failure"
          }
          else ""
        }
      ),
      button(onClick := { _ =>
        handleButtonClick()
      })("검증하기")
    )
  }

  def handleChange(e: Event) =
    setState(state.copy(password = e.target.asInstanceOf[dom.html.Input].value))

  def handleButtonClick() = {
    setState(state.copy(clicked = true, validated = state.password == "0000"))
    inputRef.current.asInstanceOf[HTMLElement].focus()
  }
}
