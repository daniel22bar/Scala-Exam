package scala_exam.enums

import com.fasterxml.jackson.core.`type`.TypeReference

class MaritalStatusWrapper extends TypeReference[MaritalStatus.type]

object MaritalStatus extends Enumeration {
  type MaritalStatus = Value
  val Married, Single = Value
}
