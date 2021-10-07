package com.itea.task2

import com.itea.task2.dto.ClazzDto

object Application extends App with LoadingModule {

  println( "DTO:    " + service.get ) // DTO:    Clazz(Title-1)
  service.save( ClazzDto("Title-2") )
}
