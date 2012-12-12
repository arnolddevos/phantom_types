sealed trait JState
trait Start extends JState 
trait Complete extends JState
trait OpenArray[E <: JState] extends JState
trait OpenObject[E <: JState] extends JState
