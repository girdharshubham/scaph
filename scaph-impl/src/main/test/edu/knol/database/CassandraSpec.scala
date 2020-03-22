package edu.knol.database

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

trait MockTemperatureDatabaseService extends TemperatureDatabaseService {

  import edu.knol.utils.Constants.Connector

  object temperatureDatabase extends TemperatureDatabase

  override def database: TemperatureDatabase = temperatureDatabase
}

object MockTemperatureDatabaseService {
  def apply(): MockTemperatureDatabaseService = new MockTemperatureDatabaseService(){}
}

trait CassandraSpec extends FlatSpec
  with Matchers
  with Inspectors
  with ScalaFutures
  with OptionValues
  with BeforeAndAfterAll
  with MockTemperatureDatabaseService
