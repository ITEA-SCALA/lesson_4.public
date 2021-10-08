package com.itea

object ClassToJson extends App {

  case class Abc(aa: Int, bb: Boolean, cc: Char, ss: String)
  val abc: Abc = Abc(123, true, 'i', "abc")

  // ///
  var iteratorAbc = abc.productElementNames
  var countElement: Int = 0

//  while (iteratorAbc.hasNext) {
//    val nameElement: String = iteratorAbc.next()
//    val valueElement: Any = abc.productElement(countElement)
//    println("name='" + nameElement + "' type='" + productElementType(valueElement) + "' index(" + countElement + ")")
//    countElement += 1
//  }


  // ///
  iteratorAbc = abc.productElementNames
  countElement = 0

  print( abc.getClass.getSimpleName + ": {")
  while (iteratorAbc.hasNext) {
    val nameElement: String = iteratorAbc.next()
    val valueElement: Any = abc.productElement(countElement)
    print( elementToJson(nameElement, valueElement, countElement) )
    countElement += 1
  }
  print("\n}")


  // ///

//  def productElementType(value: Any): String = {
//    var toType: String = "???"
//    if (value.isInstanceOf[Int]) toType = "Int"
//    if (value.isInstanceOf[Boolean]) toType = "Boolean"
//    if (value.isInstanceOf[Char]) toType = "Char"
//    toType
//  }

  def productElementType(value: Any): String = value.getClass.getName match {
    case "java.lang.Integer" => "Int"
    case "java.lang.Boolean" => "Boolean"
    case "java.lang.Character" => "Char"
    case "java.lang.String" => "String"
    case _ => "???"
  }

  def elementToJson(nameElement: String, valueElement: Any, countElement: Int): String = {
    var str: String = "\n  \"" + nameElement + "\": " + valueElement + " (" + productElementType(valueElement) + ")"
    if ( countElement!=0 ) str = "," + str
    str
  }
}
