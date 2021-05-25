package scala_exam.providers

import org.apache.poi.ss.usermodel.Row
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import scala_exam.models.Client

import scala.collection.JavaConverters.asScalaIteratorConverter

@Component
private[providers] class ClientProvider() {


  @Value("${clients_file_path}")
  var value:String = null

  def getAllClientsFromFile():List[Client]  ={
    val sere:XlsReader = new XlsReader()
    val rowIterator: Iterator[Row] = sere.getXlsFile(value).asScala
    if(rowIterator.hasNext)
      rowIterator.next()
    rowIterator.map(Client(_)).toList
  }

}
