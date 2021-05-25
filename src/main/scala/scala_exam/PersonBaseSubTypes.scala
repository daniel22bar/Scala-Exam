package scala_exam

import org.reflections.Reflections
import org.springframework.stereotype.Component
import scala_exam.models.PersonBase

import java.util

@Component
class PersonBaseSubTypes {
  val list:util.Set[Class[_ <: PersonBase]] = new Reflections("scala_exam").getSubTypesOf(classOf[PersonBase])
}
