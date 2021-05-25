package scala_exam.report_flow

import org.springframework.stereotype.Component
import scala_exam.PersonBaseSubTypes
import scala_exam.extensions.client_extenstion.ClientListRegistry.registerToClientListExtension
import scala_exam.extensions.person_extention.PersoBaseListRegistry.registerToPersonBaseListExtensions
import scala_exam.models.{Client, PersonBase, RequestConfig}
import scala_exam.providers.ContextProvider

import scala.collection.JavaConverters.asScalaSetConverter

@Component
class ReportFlowManager(pc:ContextProvider,subTypes: PersonBaseSubTypes) {

  def startReports(): Unit = {
    subTypes.list.asScala.foreach(x=>reportByClass(x))

  }

  def reportByClass(clazz:Class[_ <:PersonBase]):Unit={
    val clientsList:List[PersonBase] = pc.getProviderByType(clazz).asInstanceOf[List[PersonBase]]
    val request:RequestConfig = pc.getProviderByType(RequestConfig).asInstanceOf[RequestConfig]
    report(clientsList,request)
  }

/*  private def startClientReport(): Unit ={
    val clientsList:List[Client] = pc.getProviderByType(Client).asInstanceOf[List[Client]]
    val request:RequestConfig = pc.getProviderByType(RequestConfig).asInstanceOf[RequestConfig]
    report(clientsList,request)
    clientReport(clientsList,request)
  }

  private def startPersonReport()={
    val personsList = pc.getProviderByType(Person).asInstanceOf[List[Person]]
    val request = pc.getProviderByType(RequestConfig).asInstanceOf[RequestConfig]
    report(personsList,request)
  }*/

  private def report(list:List[PersonBase],request: RequestConfig): Unit ={

    println(list.filterWrongPhoneAndEmail.size)
    println("*************************************")
    println(list.filterNegativeAge.size)
    println("*************************************")

    println(list.filterByRequestAgeRange(request).size)
    println("*************************************")

    println(list.filterByNamePrefix(request).size)
    println("*************************************")

  }

  private def clientReport(list:List[Client],request: RequestConfig):Unit={
    println(list.filterByGender(request).filterByMaritalStatus(request).filterByNumberOfChildren(request).size)
  }


}