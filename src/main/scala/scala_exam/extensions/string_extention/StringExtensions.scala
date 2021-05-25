package scala_exam.extensions.string_extention

class StringExtensions(string: String) {

  def isValidPhone():Boolean = {
    string.map(c => c.isDigit || c == '+' || c == '-' || c == '(' || c == ')' || c==' ').reduce((a, b) => a && b)
  }
   def isValidEmail():Boolean = {
     string.contains("@") && string.endsWith(".com")
  }
}
