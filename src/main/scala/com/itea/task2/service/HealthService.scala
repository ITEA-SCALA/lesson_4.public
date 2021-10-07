package com.itea.task2.service

import com.itea.task2.dao.HealthDao
import com.itea.task2.dto.HealthDto
import io.bfil.automapper.automap

class HealthService(dao: HealthDao = new HealthDao) {
  def get: HealthDto = automap(dao.get).to[HealthDto]
}

object HealthService {
  def apply(): HealthService = new HealthService()
}