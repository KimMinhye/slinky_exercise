package scalajsreact.components

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

@react class HelloName extends StatelessComponent {
  case class Props(name: String)
  
  def render = {
    h1(s"Hello ${props.name}")
  }
}
