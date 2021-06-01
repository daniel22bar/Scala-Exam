package scala_exam.filtering

import org.springframework.stereotype.Component
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.User
import scala_exam.wrapper.RequestWrapper

@Component
class FilterClient(req: RequestWrapper) extends Filter {
  override def filter(list: List[User]): Unit = {
    println("List size before filtering is: "+list.size)
    println("Filter by gender,marital status, and number of children: ")
    val size = list.filterByGender(req.request).
      filterByMaritalStatus(req.request).
      filterByNumberOfChildren(req.request).size
    println("List size after filtering: "+size)
    println("")
  }
}
