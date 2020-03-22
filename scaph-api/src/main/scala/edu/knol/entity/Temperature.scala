package edu.knol.database

import com.outworkers.phantom.dsl.UUID

case class Temperature(
                        deviceId: UUID,
                        timestamp: String,
                        temperature: Double
                      )
