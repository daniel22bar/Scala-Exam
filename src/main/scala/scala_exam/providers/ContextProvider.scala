package scala_exam.providers

import org.springframework.stereotype.Component
import scala_exam.models.{Client, Person, RequestConfig}

import scala.reflect.ClassTag

@Component
class ContextProvider(cp:ClientProvider, pp: PersonsProvider ,rp:RequestProvider) {


  def getProviderByType[T:ClassTag](clazz:T ) = {
    clazz match {
      case _:Client.type => cp.getAllClientsFromFile()
      case _:Person.type => pp.getAllPersonFromFile()
      case _:RequestConfig.type => rp.getRequestFromFile()
      case a => println(s"class ${a} isn't supported")
    }
  }

}
