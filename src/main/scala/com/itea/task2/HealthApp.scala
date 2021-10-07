package com.itea.task2

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.itea.task2.controller.HealthController
import com.typesafe.config.{Config, ConfigFactory}

object HealthApp extends App {
  val conf = ConfigFactory.load()
  val restConfig: Config = conf.getConfig("config.rest")

  implicit val system: ActorSystem = ActorSystem("akka-http")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val port = restConfig.getString("port").toInt
  val bindingFuture = Http().bindAndHandle(HealthController.doGet, restConfig.getString("interface"), port)

  implicit val log = Logging(system, "HealthRest$")
  log.info(s"Server started at the port $port")

}
