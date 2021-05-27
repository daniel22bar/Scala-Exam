package scala_exam.adapters

import scala_exam.models.{Client, Person, User}

object ImplicitMethods {
  implicit def clientToUserList(list:List[Client]):List[User]={
    list.map(User(_))
  }

  implicit def personToUserList(list:List[Person]):List[User]={
    list.map(User(_))
  }
}
