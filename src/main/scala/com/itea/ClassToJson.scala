package com.itea

object ClassToJson extends App {

  case class Abc(aa: Int, bb: Boolean, cc: Char, ss: String)

  val abc: Abc = Abc(1, true, 'i', "abc")

  val iteratorAbc = abc.productElementNames
  var countElement: Int = 0
  while (iteratorAbc.hasNext) {
    val nameElement: String = iteratorAbc.next()
    val valueElement: Any = abc.productElement(countElement)
    println("name='" + nameElement + "' type='" + productElementType(valueElement) + "' index(" + countElement + ")")
    countElement += 1
  }

  ////  val value: Any = abc.productElement(0)
  ////  val value: Any = abc.productElement(1)
  ////  val value: Any = abc.productElement(2)
  //  val value: Any = abc.productElement(3)
  //  println( value + " >> " + productElementType(value) )

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
    //    case "java.lang.String" => "String"
    case _ => "???"
  }


}
