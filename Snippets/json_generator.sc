object json_generator {
  import au.com.langdale.json.DSL._
  
  val p1 = JBuilder.start | array | 30.0          //> p1  : au.com.langdale.json.DSL.JBuilder[au.com.langdale.json.DSL.OpenArray[a
                                                  //| u.com.langdale.json.DSL.Complete]] = JBuilder(List(30.0, [),<function1>)

	val p2 = p1 | obj | "name" -> "joe"       //> p2  : au.com.langdale.json.DSL.JBuilder[au.com.langdale.json.DSL.OpenObject[
                                                  //| au.com.langdale.json.DSL.OpenArray[au.com.langdale.json.DSL.Complete]]] = JB
                                                  //| uilder(List("joe", :, "name", {, ,, 30.0, [),<function1>)
	// val p3 = p2 | "element"
	
	p2.fullText                               //> res0: CharSequence = [30.0,{"name":"joe"
	
	val p4 = p2 | end | end                   //> p4  : au.com.langdale.json.DSL.JBuilder[au.com.langdale.json.DSL.Complete] =
                                                  //|  JBuilder(List(], }, "joe", :, "name", {, ,, 30.0, [),<function1>)
	p4.fullText                               //> res1: CharSequence = [30.0,{"name":"joe"}]
}