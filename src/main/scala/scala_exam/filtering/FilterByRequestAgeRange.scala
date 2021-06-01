package scala_exam.filtering
import org.springframework.stereotype.Component
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.User
import scala_exam.wrapper.RequestWrapper

@Component
class FilterByRequestAgeRange(req : RequestWrapper) extends Filter{
    override def filter(list: List[User]): Unit = {
        println("Filter by age range: ")
        println("List size before filtering is: "+list.size)
        println("List size after filtering: "+list.filterByRequestAgeRange(req.request).size)
        println("")
    }
}
