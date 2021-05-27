package scala_exam.flow

import org.springframework.stereotype.Component
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.{RequestConfig, User}

@Component
class ExecuteReportFlow {
  def generalReport(list:List[User],request: RequestConfig): Unit ={
    println("the size of the list before filtering" + list.size)
    println("Filter all invalid emails and phones numbers: ")
    println("List size after filtering: "+ list.filterWrongEmail.filterWrongPhone.size)
    println("Filter all negative: ")
    println("List size after filtering: "+ list.filterNegativeAge.size)
    println("Filter by age range: ")
    println("List size after filtering: "+list.filterByRequestAgeRange(request).size)
    println("Filter by name prefix: ")
    println("List size after filtering: "+list.filterByNamePrefix(request).size)
  }

   def clientReport(list:List[User],request: RequestConfig):Unit={
    println("the size of the list before filtering " + list.size)
    println("Filter by gender,marital status, and number of children: ")
    val size = list.filterByGender(request).filterByMaritalStatus(request).filterByNumberOfChildren(request).size
    println("List size after filtering: "+size)
  }
}
