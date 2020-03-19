package edu.knol.utils

import com.typesafe.config.{Config, ConfigFactory}

package object knol {
  val config: Config = ConfigFactory.load()
}
