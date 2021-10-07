package com.itea.task2

import com.itea.task2.dao.ClazzDao
import com.itea.task2.service.ClazzService
import com.softwaremill.macwire._

trait LoadingModule {
  lazy val dao = wire[ClazzDao]
  lazy val service = wire[ClazzService]
}
