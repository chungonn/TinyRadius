name := "TinyRadius"

organization := "org.tinyradius"

version := "1.0.2"

libraryDependencies += "commons-logging" % "commons-logging" % "1.2" 

publishTo <<= version { (v: String) =>
  val nexus = "repo"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "snapshots/")
  else
    Some("releases"  at nexus + "releases/")
}

parallelExecution in Test := false

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

// http://xerial.org/blog/2014/03/24/sbt/

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := false

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := 
    <licenses>
        <license>
            <name>Lesser General Public License (LGPL)</name>
            <url>LICENSE</url>
            <distribution>local</distribution>
        </license>
    </licenses>
