package controllers

import models.ItemInMemoryModel
import play.api._
import play.api.mvc._

import javax.inject._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {


  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def loginAction() = Action { request =>
    val credentials = request.body.asFormUrlEncoded
    credentials.map { args =>
      val username = args("username").head
      val password = args("password").head
// This didn't compile when ItemInMemoryModel was a class vice an object.  Why?
      if (ItemInMemoryModel.validateUser(username,password)) {
        Redirect(routes.ItemController.index())
      } else {
        Redirect(routes.HomeController.index())
      }
    }.getOrElse(Redirect(routes.HomeController.index()))
  }
}
