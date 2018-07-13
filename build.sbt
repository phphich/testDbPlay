name := "testDbPlay"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  cache
)     

play.Project.playJavaSettings
