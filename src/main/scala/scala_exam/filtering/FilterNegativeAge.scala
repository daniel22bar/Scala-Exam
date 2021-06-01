package scala_exam.filtering
import org.springframework.stereotype.Component
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.User

@Component
class FilterNegativeAge extends Filter{
    def filter(list: List[User])={
      println("List size before filtering is: "+list.size)
      println("Filter all negative: ")
      println("List size after filtering: "+ list.filterNegativeAge.size)
      println("")
    }
}
