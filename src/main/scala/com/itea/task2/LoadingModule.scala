package com.itea.task2

import com.itea.task2.controller.HealthController
import com.itea.task2.dao.{ClazzDao, HealthDao}
import com.itea.task2.service.{ClazzService, HealthService}
import com.softwaremill.macwire._

trait LoadingModule {
  lazy val dao = wire[ClazzDao]
  lazy val service = wire[ClazzService]
  lazy val healthDao = wire[HealthDao]
  lazy val healthService = wire[HealthService]
  lazy val healthController = wire[HealthController]
}
