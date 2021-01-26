name := "processors-test"

version := "1.0-SNAPSHOT"

organization := "org.clulab"

scalaVersion := "2.12.8"

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation")

// for processors-models
resolvers += ("Artifactory" at "http://artifactory.cs.arizona.edu:8081/artifactory/sbt-release").withAllowInsecureProtocol(true)

pomIncludeRepository := { (repo: MavenRepository) =>
  repo.root.startsWith("http://artifactory.cs.arizona.edu")
}

libraryDependencies ++= {
	val procVer = "8.2.3"

	Seq(
		"org.scalatest" %% "scalatest" % "3.0.1" % "test",
    	"org.clulab" %% "processors-main" % procVer,
    	"org.clulab" %% "processors-corenlp" % procVer,
    	"org.clulab" %% "processors-odin" % procVer
	)
}

