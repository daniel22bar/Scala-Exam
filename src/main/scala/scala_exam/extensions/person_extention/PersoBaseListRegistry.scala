package scala_exam.extensions.person_extention

import scala_exam.models.PersonBase

object PersoBaseListRegistry {
  implicit def registerToPersonBaseListExtensions(list: List[PersonBase]) = new PersonBaseListExtensions(list)

}
