package edu.knol.database

import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._
import edu.knol.model.TemperatureByDeviceID

class TemperatureDatabase(implicit cassandraConnection: CassandraConnection)
  extends Database[TemperatureDatabase](cassandraConnection) {

  object temperatureByDeviceId extends TemperatureByDeviceID with Connector

}

trait TemperatureDatabaseProvider extends DatabaseProvider[TemperatureDatabase]
