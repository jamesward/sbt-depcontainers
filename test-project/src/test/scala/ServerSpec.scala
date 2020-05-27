import com.dimafeng.testcontainers.scalatest.TestContainerForAll
import org.scalatest._

import scala.io.Source

class ServerSpec extends WordSpec with MustMatchers with TestContainerForAll {

  override val containerDef = HelloJava.Def()

  "container" must {
    "respond to an http request" in withContainers { container =>
      val is = Source.fromInputStream(container.rootUrl.openConnection().getInputStream)
      is.mkString must equal ("hello, world")
    }
  }

}
