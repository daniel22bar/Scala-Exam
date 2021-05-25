package scala_exam.enums

import com.fasterxml.jackson.core.`type`.TypeReference

class GenderWrapper extends TypeReference[Gender.type]

object Gender extends Enumeration {
    type Gender = Value
    val Male,Female = Value
}
