case class JBuilder[S <: JState]( buffer: B, delimit: B => B) {
  def flip(b: B = empty) = (buffer, JBuilder[S](b, delimit))
  def fullText(implicit bufRep: JSONRep[B]) = bufRep fullText buffer
}

implicit class ArrayOps[E <: JState](b: JBuilder[OpenArray[E]]) {
  def | [T:Element] (t: T) = shift(Element[T] encode t)

  ... 
}

implicit class ObjectOps[E <: JState]( b: JBuilder[OpenObject[E]]) {
  def | [T:Element](f: (String, T)) = shift(f._1, Element[T] encode f._2)

  ...
}