package com.itea.task2.controller

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.event.Logging
import com.itea.task2.HealthApp.system
import com.itea.task2.LoadingModule

object HealthController extends LoadingModule {
  implicit val log = Logging(system, "HealthController$")

  val doGet: Route =
    path("health") {
      get {
        val dto = healthService.get
        log.info(s"Server get health $dto")
        complete( healthService.get.toString ) //TODO  http://localhost:8080/health  |  { label: 'health-1', status: true }
      }
    }
}