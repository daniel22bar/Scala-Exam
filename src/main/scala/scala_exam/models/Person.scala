package scala_exam.models

import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import scala_exam.enums.Gender.Gender
import scala_exam.enums.GenderWrapper

case class Person(age:Int, name:String, @JsonScalaEnumeration(classOf[GenderWrapper]) gender:Gender,
                  company:String, email:String, phone:String, address:String)
