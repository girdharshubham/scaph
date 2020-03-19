package edu.knol.database.model

import com.outworkers.phantom.dsl._
import edu.knol.database.Temperature

import scala.concurrent.Future

abstract class TemperatureByDeviceID extends Table[TemperatureByDeviceID, Temperature] {

  override def tableName: String = "temperature"

  object deviceId extends UUIDColumn with PartitionKey {
    override def name: String = "deviceid"
  }

  object timeStamp extends StringColumn with ClusteringOrder {
    override def name: String = "timestamp"
  }

  object temperature extends DoubleColumn {
    override def name: String = "temperature"
  }

  def createTemperatureByDeviceId(deviceId: UUID, timestamp: String, temperature: Double): Future[ResultSet] =
    insert.
      value(_.deviceId, deviceId)
      .value(_.timeStamp, timestamp)
      .value(_.temperature, temperature)
      .future()

  def getByDeviceId(deviceId: UUID): Future[Option[Temperature]] =
    select
      .all()
      .where(_.deviceId eqs deviceId)
      .one()

}
