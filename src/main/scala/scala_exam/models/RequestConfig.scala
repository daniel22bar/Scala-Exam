package scala_exam.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import scala_exam.enums.Gender.Gender
import scala_exam.enums.MaritalStatus.MaritalStatus
import scala_exam.enums.{GenderWrapper, MaritalStatusWrapper}

case class RequestConfig(@JsonProperty("min_age")minAge:Int, @JsonProperty("max_age")maxAge:Int
                         , @JsonScalaEnumeration(classOf[GenderWrapper])gender:Gender,
                         @JsonProperty("prefix_name")prefixName:String,
                         @JsonScalaEnumeration(classOf[MaritalStatusWrapper])maritalStatus: MaritalStatus,
                         @JsonProperty("Number of Children")numberOfChildren:Int) extends Serializable


