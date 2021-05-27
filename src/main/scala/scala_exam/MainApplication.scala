package scala_exam

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import scala_exam.report_flow.ReportsFlowManager

@SpringBootApplication
class MainApplication

object MainApp {
    def main(args: Array[String]): Unit = {
      val context = SpringApplication.run(classOf[MainApplication])
      context.getBean(classOf[ReportsFlowManager]).startReports()
    }
  }


