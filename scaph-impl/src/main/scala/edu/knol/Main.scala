package edu.knol

import java.util.UUID

import edu.knol.database.{Temperature, TemperatureDatabase, TemperatureDatabaseService}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Main extends App {

  import utils.Constants._

  object temperatureDatabase extends TemperatureDatabase

  object databaseService extends TemperatureDatabaseService {
    override def database: TemperatureDatabase = temperatureDatabase
  }

  val user: Future[Option[Temperature]] = for {
    uuid <- databaseService.createUser(UUID.randomUUID(), "TIMESTAMP", 12.0)
    user <- databaseService.selectByDeviceId(uuid.get)
  } yield user

  user.map {
    case (user) => println(user.get)
  }
}
