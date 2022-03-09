ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.2" % Test
lazy val root = (project in file("."))
  .settings(
    name := "code02"
  )
