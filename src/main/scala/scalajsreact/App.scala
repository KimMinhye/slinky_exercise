package scalajsreact

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import scalajsreact.components._

@react class App extends StatelessComponent {
  type Props = Unit

  def render() = {
    div(
      ValidationSample()
    )
  }
}
