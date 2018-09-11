package scalajsreact.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

import scala.scalajs.js.Dynamic.literal

import org.scalajs.dom.raw.{HTMLElement, Element}

@react class ScrollBox extends StatelessComponent {
  type Props = Unit
  val box = React.createRef[Element]
  def render = {
    val outerStyle = literal(
      border = "1px solid black",
      height = "300px",
      width = "300px",
      overflow = "auto",
      position = "relative"
    )
    val innerStyle = literal(
      width = "100%",
      height = "650px",
      background = "linear-gradient(white, black)"
    )

    div(style := outerStyle, ref := box)(div(style := innerStyle))
  }

  def scrollToBottom() = {
    val scrollHeight = box.current.asInstanceOf[HTMLElement].scrollHeight
    val clientHeight = box.current.asInstanceOf[HTMLElement].clientHeight
    box.current
      .asInstanceOf[HTMLElement]
      .scrollTop = scrollHeight - clientHeight
  }
}
