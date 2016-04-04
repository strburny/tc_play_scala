package controllers

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

/**
  * Created by Vadzim_Novikau on 2/18/2016.
  */
class LoginController extends Controller {

  val loginForm: Form[LoginData] = Form {
    mapping(
      "name" -> text.verifying("Enter your login", {!_.isEmpty}),
      "password" -> text.verifying("Enter your password", {!_.isEmpty}),
      "remember" -> boolean
    )(LoginData.apply)(LoginData.unapply)
  }

  def index = Action {
    Ok(views.html.login(loginForm))
  }

  def login = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      errorForm => {
        Ok(views.html.login(errorForm))
      },
      user => {
        Redirect(routes.CoursesController.index())
      }
    )
  }

}
case class LoginData(login: String, password: String, rememberMe: Boolean)
