package scala_exam.extensions.user_list_report_extention

import scala_exam.enums.MaritalStatus
import scala_exam.extensions.string_extention.StringRegistry.registerToStringExtensions
import scala_exam.models.{RequestConfig, User}

class UserListReportExtensions(list:List[User]) {

  def filterWrongPhone: List[User]  ={
    list.filter(_.phone.isValidPhone())
  }

  def filterWrongEmail: List[User] ={
    list.filter(_.email.isValidEmail())
  }

  def filterNegativeAge:List[User]={
    list.filter(_.age>0)
  }

  def filterByRequestAgeRange(req:RequestConfig):List[User]={
    list.filter(u=> u.age>req.minAge && u.age<req.maxAge)
  }

  def filterByNamePrefix(req:RequestConfig):List[User]={
    list.filter(_.name.startsWith(req.prefixName))
  }

  def filterByGender(req:RequestConfig): List[User] ={
    list.filter(p=>p.gender==req.gender)
  }

  def filterByNumberOfChildren(req:RequestConfig): List[User] ={
    list.filter(u=>u.numberOfChildren.
      getOrElse(-1).equals( req.numberOfChildren))
  }

  def filterByMaritalStatus(req:RequestConfig): List[User] ={
    list.filter(u=>u.maritalStatus.getOrElse(MaritalStatus.Undefined).equals(req.maritalStatus))
  }



}
