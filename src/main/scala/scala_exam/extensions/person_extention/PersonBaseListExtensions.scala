package scala_exam.extensions.person_extention

import scala_exam.extensions.string_extention.StringRegistry.registerToStringExtensions
import scala_exam.models.{PersonBase, RequestConfig}

class PersonBaseListExtensions(list:List[PersonBase]) {

  def filterWrongPhoneAndEmail: List[PersonBase]  ={
    list.filter(p => p.phone.isValidPhone && p.email.isValidEmail)
  }

  def filterNegativeAge:List[PersonBase]={
    list.filter(_.age>0)
  }

  def filterByRequestAgeRange(req:RequestConfig):List[PersonBase]={
    list.filter(x=> x.age>req.minAge && x.age<req.maxAge)
  }

  def filterByNamePrefix(req:RequestConfig):List[PersonBase]={
    list.filter(_.name.startsWith(req.prefixName))
  }


}
