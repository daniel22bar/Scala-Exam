package scala_exam.flow

import org.springframework.stereotype.Component
import scala_exam.adapters.ImplicitMethods._
import scala_exam.models.{Client, Person, RequestConfig}
import scala_exam.providers.ContextProvider

@Component
class ApplicationFlowManager(cp:ContextProvider, executeReport: ExecuteReportFlow) {

  def startReports(): Unit = {
    val clientsList:List[Client] = cp.getProviderByType(Client).asInstanceOf[List[Client]]
    val personsList:List[Person] = cp.getProviderByType(Person).asInstanceOf[List[Person]]
    val request:RequestConfig = cp.getProviderByType(RequestConfig).asInstanceOf[RequestConfig]

    println("-----------------Start person Report-------------------")
    executeReport.generalReport(personsList,request)

    println("-----------------Start client Report-------------------")
    executeReport.generalReport(clientsList,request)
    executeReport.clientReport(clientsList,request)
  }



}