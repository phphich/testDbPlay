name := "testdbplay"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
  cache
)     

play.Project.playJavaSettings
