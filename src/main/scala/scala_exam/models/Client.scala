package scala_exam.models

import org.apache.poi.ss.usermodel.Row
import scala_exam.enums.Gender.Gender
import scala_exam.enums.MaritalStatus.MaritalStatus
import scala_exam.enums.{Gender, MaritalStatus}


case class Client(firstName:String,	lastName:String,gender:Gender,age:Int,email:String,phone:String,
                  education:String,	occupation:String,salary:Double,maritalStatus:MaritalStatus,	numberOfChildren:Double)
                  extends PersonBase {
 val name: String = firstName + " " + lastName
}

object Client{

   def apply(row:Row):Client={
    val cellIterator = row.cellIterator()
    val firstName:String = cellIterator.next().getStringCellValue
    val	lastName:String= cellIterator.next().getStringCellValue
    val gender:Gender= Gender.withName(cellIterator.next().getStringCellValue)
    val age:Int= cellIterator.next().getNumericCellValue.toInt
    val email:String= cellIterator.next().getStringCellValue
    val phone:String= cellIterator.next().getStringCellValue
    val education:String= cellIterator.next().getStringCellValue
    val occupation:String= cellIterator.next().getStringCellValue
    val salary:Double= cellIterator.next().getNumericCellValue
    val maritalStatus:MaritalStatus= MaritalStatus.withName(cellIterator.next().getStringCellValue)
    val numberOfChildren:Double= cellIterator.next().getNumericCellValue
    Client(firstName,lastName,gender,age,email,phone,education,occupation,salary,maritalStatus,numberOfChildren)
  }

}



