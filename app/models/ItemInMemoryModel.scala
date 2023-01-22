package models

import collection.mutable

// Play didn't like when I made this a class.  Why?
object ItemInMemoryModel {
  private val users = mutable.Map[String, String]("asdf" -> "fdsa")
  private val items = mutable.Map[String, List[String]]("asdf" -> List("Shirt","Pants","Coat"))
  def validateUser(username: String, password: String): Boolean = {
    users.get(username).map(_ == password).getOrElse(false)
  }

  def createUser(username: String, password: String): Boolean = {
    if (users.contains(username)) false else {
      users(username) = password
      true
    }
  }

  def getItems(username: String): Seq[String] = {
    items.get(username).getOrElse(Nil)
  }
// TODO: Item needs unique generated item_id, store, account num
  def addItem(username: String, item: String): Unit = ???

  def removeItem(username: String, itemId: Int): Boolean = ???
}
