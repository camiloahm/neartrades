package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.util.{Failure, Success, Try}

class MathController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def sqrt(number: String) = Action { implicit request =>
    Try(number.toInt) match {
      case Success(ans) if ans >= 0 => Ok(s"The answer is ${Math.sqrt(ans)}")
      case Success(ans) => BadRequest(s"The inout ${ans} must be greater than zero")
      case Failure(ex) => InternalServerError(s"Could not extract content from ${number}")
    }
  }

}
