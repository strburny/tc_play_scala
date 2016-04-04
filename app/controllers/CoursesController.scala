package controllers

import play.api._
import play.api.mvc._

/**
  * Created by Vadzim_Novikau on 2/18/2016.
  */
class CoursesController extends Controller {

  def index = Action {
    Ok(views.html.courses())
  }

}
