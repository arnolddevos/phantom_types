object RocketWithVals {
  case class Rocket( o: O2, f: Fuel )
  
  sealed trait O2
  case object NoO2 extends O2
  case object HasO2 extends O2
  
  sealed trait Fuel
  case object NoFuel extends Fuel
  case object Fueled extends Fuel
  
  def createRocket() = Rocket(NoO2, NoFuel)       //> createRocket: ()RocketWithVals.Rocket
  
  def addFuel(x: Rocket) = x match {
    case Rocket(o, NoFuel) => Rocket(o, Fueled)
    case _ => throw new IllegalStateException
  }                                               //> addFuel: (x: RocketWithVals.Rocket)RocketWithVals.Rocket
  
  def addO2(x: Rocket) = x match {
    case Rocket(NoO2, f) => Rocket(HasO2, f)
    case _ => throw new IllegalStateException
  }                                               //> addO2: (x: RocketWithVals.Rocket)RocketWithVals.Rocket
  
  def launch(x: Rocket) = x match {
    case Rocket(HasO2, Fueled) => "launched!"
    case _ => throw new IllegalStateException
  }                                               //> launch: (x: RocketWithVals.Rocket)String
    
  val goodSeq = launch(addO2(addFuel(createRocket)))
                                                  //> goodSeq  : String = launched!
  
  val anotherGoodSeq = launch(addFuel(addO2(createRocket)))
                                                  //> anotherGoodSeq  : String = launched!
  
  
  // val badSeq = launch(addFuel(createRocket()))
  
  // val anotherBadSeq = launch(addFuel(addO2(addFuel(createRocket()))))
}