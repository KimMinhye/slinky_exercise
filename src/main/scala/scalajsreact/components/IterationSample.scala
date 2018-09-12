package scalajsreact.components

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import org.scalajs.dom.html
import org.scalajs.dom.raw.{HTMLElement, Event}

import scala.collection.mutable.ListBuffer

@react class IterationSample extends Component {
  type Props = Unit
  case class State(names: ListBuffer[String], name: String)

  def initialState = State(ListBuffer("눈사람", "얼음", "눈", "바람"), "")

  def render() = {
    val nameList = state.names.map(name =>
      li(key := name, onDoubleClick := { (_) =>
        handleRemove(name)
      })(name))

    div(
      input(onChange := { handleChange _ }, value := { state.name }),
      button(onClick := { _ =>
        handleInsert()
      })("확인"),
      ul(nameList)
    )
  }

  def handleChange(e: Event) = {
    setState(state.copy(name = e.target.asInstanceOf[html.Input].value))
  }

  def handleInsert() = {
    setState(state.copy(state.names += state.name, ""))
  }

  def handleRemove(key: String) = {
    setState(state.copy(names = state.names -= key))
  }
}
