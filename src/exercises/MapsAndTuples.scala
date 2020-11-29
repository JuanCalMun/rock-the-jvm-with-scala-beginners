package exercises

import scala.annotation.tailrec

object MapsAndTuples extends App {

  /*
  *   1.  What would happend if I had two entries with "Jim" and "JIM" and y run
  *
  *   println(phonebook.map(pair => pair_1.toLowerCase -> pair._2))
  */
  println("\n \t\t\t*******\t Exercise 1. map with same key\t*******")
  val phonebook = Map("Fry" -> 12345, "Leela" -> 4321, "Bender" -> 666, "FRY" -> 141414).withDefaultValue(-1)
  val lowerCasedKeyPhonebook = phonebook.map(pair => pair._1.toLowerCase -> pair._2)
  println(s"\nphonebook:\n $phonebook")
  println(s"\nlowerCasedKeyPhonebook:\n $lowerCasedKeyPhonebook")


  /*
  *   2.  Overly simplified social network based on maps
  *       - Add a person to the network
  *       - Remove
  *       - Friend (mutual)
  *       - Unfried
  *
  *       - number of friends of a person
  *       - person with most friends
  *       - how many people have NO friends
  *       - if there is a social connection btween two people (direct or not)
  */


  println("\n\n \t\t\t*******\t Exercise 2. Overly simplified social network based on maps\t*******")

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())


  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA: Set[String] = network(personA) + personB
    val friendsB: Set[String] = network(personB) + personA
    network + (personA -> friendsA) + (personB -> friendsB)
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA: Set[String] = network(personA) - personB
    val friendsB: Set[String] = network(personB) - personA
    network + (personA -> friendsA) + (personB -> friendsB)
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends isEmpty) acc
      else removeAux(friends.tail, unfriend(acc, friends.head, person))

    removeAux(network(person), network) - person
  }

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  def mostPopularPerson(network: Map[String, Set[String]]): String = {
    def mostPopularPersonAux(network: Map[String, Set[String]],
                             acc: (String, Set[String])): String =
      if (network isEmpty) acc._1
      else if (network.head._2.size > acc._2.size) mostPopularPersonAux(network.tail, (network.head._1, network.head._2))
      else mostPopularPersonAux(network.tail, acc)

    mostPopularPersonAux(network, ("empty", Set()))
  }

  def improvedMostPopularPerson(network: Map[String, Set[String]]): String =
    network.maxBy(_._2.size)._1

  def alonePeople(network: Map[String, Set[String]]): Int = {
    network.count(_._2.isEmpty)
  }

  def socialConnection(network: Map[String, Set[String]],
                       personA: String,
                       personB: String): Boolean = {
    @tailrec
    def socialConnectionAux(target: String,
                            consideredPeople: Set[String],
                            discoveredPeople: Set[String]): Boolean =
      if (discoveredPeople isEmpty) false
      else if (discoveredPeople.head == target) true
      else if (consideredPeople.contains(discoveredPeople.head))
        socialConnectionAux(target, consideredPeople, discoveredPeople.tail)
      else socialConnectionAux(
        target,
        consideredPeople + discoveredPeople.head,
        discoveredPeople.tail ++ network(discoveredPeople.head))


    socialConnectionAux(personB, Set(), network(personA) + personA)
  }

  var network: Map[String, Set[String]] = Map()
  network = add(network, "Bender")
  network = add(network, "Fry")
  network = add(network, "Leela")
  network = add(network, "Zoiberg")

  network = friend(network, "Fry", "Bender")
  network = friend(network, "Fry", "Leela")
  println(s"\nnetwork:\n $network")

  println(s"\nremove Leela:\n ${remove(network, "Leela")}")
  println(s"\nremove Fry:\n ${remove(network, "Fry")}")

  println(s"\nnFriends Fry: ${nFriends(network, "Fry")}")
  println(s"nFriends Leela: ${nFriends(network, "Leela")}")
  println(s"nFriends Zoiberg: ${nFriends(network, "Zoiberg")}")

  println(s"MostPopularPerson: ${mostPopularPerson(network)}")
  println(s"ImprovedMostPopularPerson: ${improvedMostPopularPerson(network)}")

  println(s"\nAlonePeople: ${alonePeople(network)}")

  println(s"\nSocial connection Fry,Bender: ${socialConnection(network, "Fry", "Bender")}")
  println(s"Social connection Bender,Leela: ${socialConnection(network, "Leela", "Bender")}")
  println(s"Social connection Fry,Zoiberg: ${socialConnection(network, "Fry", "Zoiberg")}")

}

