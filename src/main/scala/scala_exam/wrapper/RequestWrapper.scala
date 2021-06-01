package scala_exam.wrapper

import org.springframework.stereotype.Component
import scala_exam.models.RequestConfig
import scala_exam.providers.ContextProvider

@Component
class RequestWrapper(cp: ContextProvider) extends Serializable{
  val request:RequestConfig = cp.getProviderByType(RequestConfig).asInstanceOf[RequestConfig]
}
