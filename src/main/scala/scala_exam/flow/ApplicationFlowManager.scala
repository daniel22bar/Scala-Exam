package scala_exam.flow

import scala_exam.adapters.ImplicitMethods._
import org.springframework.stereotype.Component
import scala_exam.filtering.Filter
import scala_exam.models.{Client, Person}
import scala_exam.providers.ContextProvider
import scala.collection.JavaConverters._
@Component
class ApplicationFlowManager(filters:java.util.List[Filter],cp:ContextProvider) {
  def startReports(): Unit = {
    val clientsList: List[Client] = cp.getProviderByType(Client).asInstanceOf[List[Client]]
    val personsList: List[Person] = cp.getProviderByType(Person).asInstanceOf[List[Person]]
    println("------------------------ Filtering Clients --------------------------")
    filters.asScala.foreach(x=> x.filter(clientsList))
    println("------------------------ Filtering Persons --------------------------")
    filters.asScala.foreach(x=> x.filter(personsList))
  }
}