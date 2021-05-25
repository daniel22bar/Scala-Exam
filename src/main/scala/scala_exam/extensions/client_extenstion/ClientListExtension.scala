package scala_exam.extensions.client_extenstion

import scala_exam.models.{Client, RequestConfig}

class ClientListExtension(list:List[Client]) {
  def filterByNumberOfChildren(req:RequestConfig):List[Client]={
    list.filter(_.numberOfChildren == req.numberOfChildren)
  }

  def filterByMaritalStatus(req:RequestConfig)={
    list.filter(p=>p.maritalStatus==req.maritalStatus)
  }

  def filterByGender(req:RequestConfig)={
    list.filter(p=>p.maritalStatus==req.maritalStatus)
  }

}
