import hudson.model.Cause.UserIDCause
import hudson.model.User
import hudson.tasks.Mailer.UserProperty

def currentBuild = Thread.currentThread().executable
def triggeredBy = buildTriggeredBy(currentBuild)

def buildTriggeredBy(Build) {
  def buildCause = build.getCause(UserIdCause)
  if(build.Cause != null) {
    def userId = buildCause.getUserId()
    return User.get(userId).getProperty(UserProperty).getAddress()
  }
}
