import com.google.inject.AbstractModule
import java.time.Clock

import services.{AtomicCounter, Counter}

/**
I stole all of this from the play-scala-starter-example repo
 */
class Module extends AbstractModule {

  override def configure() = {
    // Use the system clock as the default implementation of Clock
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
    // Set AtomicCounter as the implementation for Counter.
    bind(classOf[Counter]).to(classOf[AtomicCounter])
  }

}
