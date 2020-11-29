package exercises

import scala.util.Random

object OptionExercises extends App {

  val config: Map[String, String] = Map(
    "host" -> "172.45.26.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random()

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }


  private def establishConnection(n: Int = 0): Unit = {
    val host = config.get("host")
    val port = config.get("port")
    val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
    connection.map(_.connect).foreach(c => println(s"Try $n : $c"))
  }

  private def establishConnectionImproved(n: Int = 0): Unit =
    config.get("host")
      .flatMap(h => config.get("port")
        .flatMap(p => Connection(h, p))
        .map(c => c.connect))
      .foreach(c => println(s"Try $n : $c (improved)"))

  private def establishConnectionBest(n: Int = 0): Unit = {
    val connectionStatus = for {
      h <- config.get("host")
      p <- config.get("port")
      connection <- Connection(h, p)
    } yield connection.connect
    connectionStatus.foreach(c => println(s"Try $n : $c (best)"))
  }

  for (i <- 0 to 10) {
    establishConnection(i)
    establishConnectionImproved(i)
    establishConnectionBest(i)
  }

}
