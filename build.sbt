
lazy val root = (project in file("."))
  .settings(
    name := "iex",
    scalaVersion := "2.12.7",
    version := "1.0-SNAPSHOT"
  )

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.5"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.8"

// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12" % Test

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// skip javadoc on stage
// https://www.scala-sbt.org/sbt-native-packager/formats/universal.html
mappings in (Compile, packageDoc) := Seq()
sources in (Compile, doc) := Seq()
publishArtifact in (Compile, packageDoc) := false
