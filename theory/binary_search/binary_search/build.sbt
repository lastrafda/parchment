val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name         := "binary_search",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.2.10",
      "org.scalatest" %% "scalatest" % "3.2.10" % "test"
    )
  )
