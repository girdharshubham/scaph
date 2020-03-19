name := "scaph"

version := "0.1"

scalaVersion := "2.12.8"

val phantomVersion = "2.13.0"
val typesafeConfigVersion = "1.4.0"

val phantomDSL = "com.outworkers" %% "phantom-dsl" % phantomVersion
val typesafeConfig = "com.typesafe" % "config" % typesafeConfigVersion

lazy val root = (project in file("."))
  .settings(
    mainClass in (Compile, run) := Some("edu.knol.Main"),
    run := {
      (run in `scaph-impl` in Compile).evaluated
    }
  ).aggregate(`scaph-api`, `scaph-impl`)

lazy val `scaph-api` = (project in file("scaph-api"))
  .settings(
    libraryDependencies ++= List(
      phantomDSL
    )
  )

lazy val `scaph-impl` = (project in file("scaph-impl"))
    .settings(
      libraryDependencies ++= List (
        phantomDSL,
        typesafeConfig
      )
    ).dependsOn(`scaph-api`)