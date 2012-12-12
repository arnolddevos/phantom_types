object RocketWithTypes {
  case class Rocket[ O <: O2, F <: Fuel ]()
  
  sealed trait O2
  trait NoO2 extends O2
  trait HasO2 extends O2
  
  sealed trait Fuel
  trait NoFuel extends Fuel
  trait Fueled extends Fuel
  
  def createRocket() = Rocket[NoO2, NoFuel]       //> createRocket: ()RocketWithTypes.Rocket[RocketWithTypes.NoO2,RocketWithTypes.
                                                  //| NoFuel]
  
  def addFuel[O <: O2](x: Rocket[O, NoFuel]) = Rocket[O, Fueled]
                                                  //> addFuel: [O <: RocketWithTypes.O2](x: RocketWithTypes.Rocket[O,RocketWithTyp
                                                  //| es.NoFuel])RocketWithTypes.Rocket[O,RocketWithTypes.Fueled]
  
  def addO2[F <: Fuel](x: Rocket[NoO2, F]) = Rocket[HasO2, F]
                                                  //> addO2: [F <: RocketWithTypes.Fuel](x: RocketWithTypes.Rocket[RocketWithTypes
                                                  //| .NoO2,F])RocketWithTypes.Rocket[RocketWithTypes.HasO2,F]
  
  def launch(x: Rocket[HasO2, Fueled]) = "launched!"
                                                  //> launch: (x: RocketWithTypes.Rocket[RocketWithTypes.HasO2,RocketWithTypes.Fue
                                                  //| led])String
    
  val goodSeq = launch(addO2(addFuel(createRocket)))
                                                  //> goodSeq  : String = launched!
  
  val anotherGoodSeq = launch(addFuel(addO2(createRocket)))
                                                  //> anotherGoodSeq  : String = launched!
  
  // val badSeq = launch(addFuel(createRocket()))
  
  // val anotherBadSeq = launch(addFuel(addO2(addFuel(createRocket()))))

}