package scala_exam.extensions.user_list_extention

import scala_exam.extensions.string_extention.StringRegistry.registerToStringExtensions
import scala_exam.models.{RequestConfig, User}

class UserListExtensions(list:List[User]) {

  def filterWrongPhoneAndEmail: List[User]  ={
    list.filter(u => u.phone.isValidPhone && u.email.isValidEmail)
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
      getOrElse(println(s"for ${u.name} marital status is ${u.maritalStatus.get}")).equals( req.numberOfChildren))
  }

  def filterByMaritalStatus(req:RequestConfig): List[User] ={
    list.filter(u=>u.maritalStatus.
      getOrElse(println(s"for ${u.name} marital status is ${u.maritalStatus.get}"))==req.maritalStatus)
  }



}
