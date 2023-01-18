package controllers

import play.api.mvc._
import services.Counter

import javax.inject.{Inject, Singleton}

@Singleton
class ItemController @Inject() (val cc:ControllerComponents,
                                counter: Counter) extends AbstractController(cc) {

  def count: Action[AnyContent] = Action { Ok(counter.nextCount().toString) }

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.item(count().toString()))
  }

}
