package models

import collection.mutable

// Play didn't like when I made this a class.  Why?
object ItemInMemoryModel {
  private val users = mutable.Map[String, String]("asdf" -> "fdsa ")

  def validateUser(username: String, password: String): Boolean = {
    users.get(username).map(_ == password).getOrElse(false)
  }

  def createUser(username: String, password: String): Boolean = ???

  def getItems(username: String): Seq[String] = ???

  def addItem(username: String, item: String): Unit = ???

  def removeItem(username: String, itemId: Int): Boolean = ???
}
