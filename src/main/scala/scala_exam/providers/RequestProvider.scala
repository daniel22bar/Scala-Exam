package scala_exam.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import scala_exam.models.RequestConfig

import scala.io.Source

@Component
private[providers] class RequestProvider {

  @Value("${request_file_path}")
  var value:String = null


  def getRequestFromFile():RequestConfig ={
    val personsLines = Source.fromFile(value).getLines().mkString("\n")
    val json = getJson(personsLines)

    val jsonObjectMapper = new ObjectMapper() with ScalaObjectMapper
    jsonObjectMapper.registerModule(DefaultScalaModule)
    jsonObjectMapper.readValue(json, classOf[RequestConfig])
  }

  private def getJson(personsLines:String):String={
    personsLines.replace("[", "")
      .replace("]", "")
      .replaceAll("(?i)\"married\"", "\"Married\"")
      .replaceAll("(?i)\"single\"", "\"Single\"")
  }
}
