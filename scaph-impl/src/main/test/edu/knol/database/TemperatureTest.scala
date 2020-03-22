package edu.knol.database

import java.util.UUID

import com.outworkers.phantom.dsl._
import com.outworkers.util.testing._
import edu.knol.Main.databaseService

import scala.concurrent.Future

class TemperatureTest extends  CassandraSpec  with TemperatureGenerator {

  private val UUIDString: String = "b553eec0-6c58-11ea-9cfe-f5298208794c"
  private val TimeStampString: String = "-1000000000-01-01T00:00:00Z"
  private val TemperatureValue: Double = 12.3

  override def beforeAll(): Unit = {
    super.beforeAll()
    database.create()
  }
  override def afterAll(): Unit = {
    super.afterAll()
  }

  "Temperature" should "inserted into cassandra" in {
    val sample: Temperature = gen[Temperature]
    val future: Future[Option[UUID]] = MockTemperatureDatabaseService()
      .createUser(sample.deviceId, sample.timestamp, sample.temperature)

    whenReady(future){ result =>
      println(result.get)
      result.get.toString shouldBe UUIDString
    }
  }

  "Temperature" should "get data from cassandra"  in {
    val resultFuture: Future[Option[Temperature]] = MockTemperatureDatabaseService().selectByDeviceId(UUID.fromString("b553eec0-6c58-11ea-9cfe-f5298208794c"))
    whenReady(resultFuture) {
      result =>
        val temperature = result.get
        temperature.deviceId.toString shouldBe "b553eec0-6c58-11ea-9cfe-f5298208794c"
        temperature.temperature shouldBe TemperatureValue
        temperature.timestamp shouldBe TimeStampString
    }
  }
}


