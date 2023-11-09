import hudson.model.Cause.UserIdCause
import hudson.model.User
impit hudson.tasks.Mailer.UserProperty

def currentBuild = Thread.currentThread().executable
def triggeredBy = buildTriggeredBy(currentBuild)

def buildTriggeredBy(build) {
  def buildCause = build.getCause(UserIdCause)
  if(buildCause != null) {
    def userId = buildCause.getUserId()
    return User.get(userId).getProperty(userProperty).getAddress()
  }
}

println "triggeredBy = ${triggeredBy}"
