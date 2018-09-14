package scalajsreact.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

import scala.scalajs.js.Dynamic.literal

import org.scalajs.dom
import org.scalajs.dom.raw.{Element, HTMLElement}

@react class LifeCycleSample extends Component {
  case class Props(color: String)
  case class State(number: Int, color: String)
  val myRef  = React.createRef[Element]
  val hStyle = literal(color = props.color)

  def initialState = State(0, "")

  // override def getDerivedStateFromProps(nextProps: Props,
  //                                       prevState: State): State = {
  //   if (nextProps.color != prevState.color)
  //     State(number = 0, color = nextProps.color)
  //   null.asInstanceOf[State]
  // }

  override def componentDidMount() = { dom.console.log("componentDidMount") }

  override def shouldComponentUpdate(nextProps: Props,
                                     nextState: State): Boolean = {
    dom.console.log(s"shouldComponentUpdate ${nextProps} ${nextState}")
    nextState.number % 10 != 4
  }

  override def componentWillUnmount() = {
    dom.console.log("componentWillUnmount")
  }

  override def getSnapshotBeforeUpdate(prevProps: Props,
                                       prevState: State): Snapshot = {
    dom.console.log("getSnapshotBeforeUpdate")
    if (prevProps.color != props.color)
      myRef.current.asInstanceOf[HTMLElement].style.color
    null.asInstanceOf[Snapshot]
  }

  override def componentDidUpdate(prevProps: Props,
                                  prevState: State,
                                  snapshot: Snapshot) = {
    dom.console.log(s"componentDidUpdate ${prevProps} ${prevState}")
    // if (snapshot)
    // dom.console.log(s"업데이트 되기 직전 색생 : ${snapshot} ")
  }

  def render() = {
    dom.console.log("render")
    div(
      h1(style := { hStyle }, ref := myRef)({ state.number }),
      p(s"color: ${state.color}"),
      button(onClick := { _ =>
        handleClick
      })("더하기")
    )
  }

  def handleClick() = {
    setState(state.copy(number = state.number + 1))
  }
}
