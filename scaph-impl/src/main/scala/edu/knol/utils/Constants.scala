package edu.knol.utils

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoint}

object Constants {
  private val CassandraHostKey: String = "cassandra.contact-point"
  private val CassandraPortKey: String = "cassandra.port"
  private val KeySpaceKey: String = "cassandra.keyspace"
  private val TableNameKey: String = "cassandra.table"

  import knol._

  lazy val CassandraHost: String = config.getString(CassandraHostKey)
  lazy val CassandraPort: Int = config.getInt(CassandraPortKey)
  lazy val KeySpace: String = config.getString(KeySpaceKey)
  lazy val TableName: String = config.getString(TableNameKey)
  lazy implicit val Connector: CassandraConnection = ContactPoint(CassandraHost, CassandraPort)
    .keySpace(KeySpace)
}
