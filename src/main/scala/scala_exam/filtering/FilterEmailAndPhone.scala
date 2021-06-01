package scala_exam.filtering
import org.springframework.stereotype.Component
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.User

@Component
class FilterEmailAndPhone extends Filter{
  def filter(list: List[User]):Unit = {
    println("List size before filtering is: "+list.size)
    println("Filter all invalid emails and phones numbers: ")
    println("List size after filtering: "+ list.filterWrongEmail.filterWrongPhone.size)
    println("")
  }
}

