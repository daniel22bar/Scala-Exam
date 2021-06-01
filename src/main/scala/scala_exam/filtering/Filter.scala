package scala_exam.filtering
import scala_exam.models.User

trait Filter {
    def filter(list: List[User]);
}
