
lazy val root = (project in file("."))
  .settings(
    name := "iex",
    version := "1.0-SNAPSHOT"
  )

libraryDependencies += "com.google.code.gson" % "gson" % "2.10.1"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.14"

// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.13.2" % Test

// skip javadoc on stage
// https://www.scala-sbt.org/sbt-native-packager/formats/universal.html
mappings in (Compile, packageDoc) := Seq()
sources in (Compile, doc) := Seq()
publishArtifact in (Compile, packageDoc) := false
