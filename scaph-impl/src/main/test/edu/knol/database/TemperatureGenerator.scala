package edu.knol.database

import java.time.{Instant}
import java.util.UUID

import com.outworkers.util.samplers.Sample

trait TemperatureGenerator {
  implicit object SongGenerator extends Sample[Temperature] {
    override def sample: Temperature = {
      Temperature(UUID.fromString("b553eec0-6c58-11ea-9cfe-f5298208794c"), Instant.MIN.toString, 12.3)
    }
  }
}
