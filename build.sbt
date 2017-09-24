name := "processors-test"

version := "1.0-SNAPSHOT"

organization := "org.clulab"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation")

libraryDependencies ++= {
	val procVer = "6.1.3-SNAPSHOT"

	Seq(
		"org.scalatest" %% "scalatest" % "2.2.4" % "test",
    	"org.clulab" %% "processors-main" % procVer,
    	"org.clulab" %% "processors-corenlp" % procVer,
    	"org.clulab" %% "processors-modelsmain" % procVer,
    	"org.clulab" %% "processors-modelscorenlp" % procVer,
    	"org.clulab" %% "processors-odin" % procVer
	)
}

