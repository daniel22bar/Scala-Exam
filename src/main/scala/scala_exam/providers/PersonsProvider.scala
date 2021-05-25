package scala_exam.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import scala_exam.models.Person

import scala.io.Source


@Component
private[providers] class PersonsProvider  {

  @Value("${persons_file_path}")
  var value:String = null

  def getAllPersonFromFile(): List[Person] ={
    val personsLines = Source.fromFile(value).getLines().mkString("\n")
    val jsonArray = getJsonArray(personsLines)

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    jsonArray.map(x => mapper.readValue(x, classOf[Person])).toList
  }

  private def getJsonArray(personsLines: String):Array[String]={
    personsLines.replace("[", "").replace("]", "")
      .split("},").map(x => x + "}")
      .map(_.replaceAll("(?i)\"male\"", "\"Male\""))
      .map(_.replaceAll("(?i)\"female\"", "\"Female\""))
  }
}
