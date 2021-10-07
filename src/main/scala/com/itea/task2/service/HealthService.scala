package com.itea.task2.service

import com.itea.task2.dao.HealthDao
import com.itea.task2.dto.HealthDto
import io.bfil.automapper.automap

class HealthService(healthDao: HealthDao) {
  def get: HealthDto = automap(healthDao.get).to[HealthDto]
}
