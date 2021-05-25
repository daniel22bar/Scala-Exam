package scala_exam.extensions.client_extenstion

import scala_exam.models.Client

object ClientListRegistry {
  implicit def registerToClientListExtension(clients:List[Client]) = new ClientListExtension(clients)

}
