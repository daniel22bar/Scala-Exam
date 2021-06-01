package scala_exam.filtering

import org.springframework.stereotype.Component
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.User
import scala_exam.wrapper.RequestWrapper

@Component
class FilterByNamePrefix(req : RequestWrapper) extends Filter {
  override def filter(list: List[User]): Unit = {
    println("Filter by name prefix: ")
    println("List size before filtering is: "+list.size)
    println("List size after filtering: "+list.filterByNamePrefix(req.request).size)
    println("")
  }
}
