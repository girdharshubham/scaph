package edu.knol.database

import com.outworkers.phantom.dsl._

import scala.concurrent.Future

trait TemperatureDatabaseService extends TemperatureDatabaseProvider {
  def createUser(uuid: UUID, timestamp: String, temperature: Double): Future[Option[UUID]] =
    database
      .temperatureByDeviceId
      .createTemperatureByDeviceId(uuid, timestamp, temperature)
      .map(rs => if (rs.wasApplied()) Some(uuid) else None)

  def selectByDeviceId(uuid: UUID): Future[Option[Temperature]] =
    database
      .temperatureByDeviceId
      .getByDeviceId(uuid)
}

