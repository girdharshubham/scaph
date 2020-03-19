package edu.knol.utils

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoint}

object Constants {
  private val CassandraHostKey: String = "cassandra.contact-point"
  private val CassandraPortKey: String = "cassandra.port"
  private val KeySpaceKey: String = "cassandra.keyspace"

  val CassandraHost: String = knol.config.getString(CassandraHostKey)
  val CassandraPort: Int = knol.config.getInt(CassandraPortKey)
  val KeySpace = knol.config.getString(KeySpaceKey)
  implicit val Connector: CassandraConnection = ContactPoint(CassandraHost, CassandraPort)
    .keySpace(KeySpace)
}
