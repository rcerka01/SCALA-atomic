package PLAYparticles

/**
  * Created by raitis on 21/03/2016.
  */


// Action
trait ActionFunction[-R[_], +P[_]] {}
trait ActionBuilder[+R[_]] extends ActionFunction[Request, R]  {
//  final def apply[A](bodyParser: BodyParser[A])(block: R[A] => Result): Action[A] = async(bodyParser) { req: R[A] =>
//    Future.successful(block(req))
//  }

}
object Action extends ActionBuilder[Request] {}

// Request
trait RequestHeader {}
trait Request[+A] extends RequestHeader {}

// Result
trait Results {
  val Ok = new Status(204)
}

// Results
// header: ResponseHeader, body: Enumerator[Array[Byte]], connection: HttpConnection.Connection = HttpConnection.KeepAlive
case class Result() {}
class Status(status: Int) extends Result

//Controller
//extends Results with BodyParsers with HttpProtocol with Status with HeaderNames with ContentTypes with RequestExtractors with Rendering {
trait Controller extends Results {}




// OUTPUT
class PlayControllers extends Controller {

//  def index = Action {
//    Ok
//  }

}
