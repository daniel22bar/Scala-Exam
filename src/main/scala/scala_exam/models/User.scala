package scala_exam.models

import scala_exam.enums.Gender.Gender
import scala_exam.enums.MaritalStatus.MaritalStatus

case class User(age:Int, phone:String, email:String, name:String,gender: Gender,numberOfChildren:Option[Int] = null,maritalStatus:Option[MaritalStatus] = null)

object User{

   def apply(c: Client): User ={
     User(c.age,c.phone,c.email,c.firstName+c.lastName,c.gender,Option(c.numberOfChildren),Option(c.maritalStatus))
   }

   def apply(p: Person): User ={
     User(p.age,p.phone,p.email,p.name,p.gender)
   }

}
