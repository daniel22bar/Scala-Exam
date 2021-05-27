package scala_exam.report_flow

import org.springframework.stereotype.Component
import scala_exam.adapters.ImplicitMethods._
import scala_exam.extensions.user_list_report_extention.UserListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.{Client, Person, RequestConfig, User}
import scala_exam.providers.ContextProvider

@Component
class ReportsFlowManager(pc:ContextProvider) {

  def startReports(): Unit = {
    val clientsList:List[Client] = pc.getProviderByType(Client).asInstanceOf[List[Client]]
    val personsList:List[Person] = pc.getProviderByType(Person).asInstanceOf[List[Person]]

    val request:RequestConfig = pc.getProviderByType(RequestConfig).asInstanceOf[RequestConfig]
    println("-----------------Start person Report-------------------")
    generalReport(personsList,request)
    println("-----------------Start client Report-------------------")
    generalReport(clientsList,request)
    clientReport(clientsList,request)

  }

  private def generalReport(list:List[User],request: RequestConfig): Unit ={
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

  private def clientReport(list:List[User],request: RequestConfig):Unit={
    println("the size of the list before filtering " + list.size)
    println("Filter by gender,marital status, and number of children: ")
    val size = list.filterByGender(request).filterByMaritalStatus(request).filterByNumberOfChildren(request).size
    println("List size after filtering: "+size)
  }

}