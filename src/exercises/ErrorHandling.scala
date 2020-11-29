package exercises

import scala.util.{Random, Try}

object ErrorHandling extends App {

  val hostName = "localhost"
  val port = "8080"

  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random()
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random()

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

    def getSafeConnection(host: String, port: String): Try[Connection] =
      Try(getConnection(host, port))
  }

  //  If you get the html page from the connection, print it to the console i.e. call render HTML
  def tryConnection(n: Int, url: String): Unit = {
    val triedConnection: Try[Connection] = HttpService.getSafeConnection(hostName, port)
    val triedHtml: Try[String] = triedConnection.flatMap(_.getSafe(url))
    triedHtml.foreach(html => renderHTML(s"try $n: $html"))
  }

  def tryConnectionImproved(n: Int, url: String): Unit = {
    for {
      connection <- HttpService.getSafeConnection(hostName, port)
      html <- connection.getSafe(url)
    } renderHTML(s"try $n: $html(improved)")
  }

  for (i <- 0 to 100) {
    tryConnection(i, "/users")
    tryConnectionImproved(i, "/usersImproved")
  }


}
