name          := "HMRC Scala Test"
version       := "1.0"
organization  := "vlach.io"
scalaVersion  := "2.11.8"

libraryDependencies ++= Vector(
  "com.chuusai"            %% "shapeless"      % "2.3.0",
  "org.scalaz"             %% "scalaz-core"    % "7.2.2",
  "org.scalatest"          %% "scalatest"      % "2.2.6" % "test"
)
