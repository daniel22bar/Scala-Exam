package scala_exam.extensions.string_extention

object StringRegistry {
  implicit def registerToStringExtensions(string: String) = new StringExtensions(string)

}
