package scalajsreact

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._
import scalajsreact.components._

@react class App extends StatelessComponent {
  type Props = Unit

  def render() = {
    div( className := "box blue")
  }
}
