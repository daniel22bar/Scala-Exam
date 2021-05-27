package scala_exam.extensions.user_list_report_extention

import scala_exam.models.User

object UserListRegistry {
  implicit def registerToPersonBaseListExtensions(list: List[User]) = new UserListReportExtensions(list)

}
