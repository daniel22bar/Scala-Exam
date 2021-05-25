package scala_exam

import org.reflections.Reflections
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import scala_exam.models.PersonBase
import scala_exam.report_flow.ReportFlowManager

import java.util

@SpringBootApplication
class MainApplication

object MainApp {
    def main(args: Array[String]): Unit = {
      val context = SpringApplication.run(classOf[MainApplication])
      context.getBean(classOf[ReportFlowManager]).startReports

    }

  @Bean
  def getBaseSubType(): java.util.Set[Class[_ <: PersonBase]] ={

    val reflections = new Reflections("scala_exam")
    val set: util.Set[Class[_ <: PersonBase]] = reflections.getSubTypesOf(classOf[PersonBase])
    set
  }


  }


