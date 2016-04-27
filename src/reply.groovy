// リプライ

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Grab('org.twitter4j:twitter4j-core:4.0.4')
import twitter4j.StatusUpdate

def targetStatusId = 

def targetIds

def tweet = """\
${targetIds ? targetIds + ' ' : ''}
""".trim()

def now = LocalDateTime.now()

def twitter = Configuration.newTwitter()

def statusUpdate = new StatusUpdate(tweet)
statusUpdate.inReplyToStatusId = targetStatusId

def status = twitter.updateStatus(statusUpdate)

println("""\
[Reply] ${now.format(DateTimeFormatter.ofPattern('yyyy-MM-dd HH:mm:ss'))} target: ${targetStatusId}
statusId: ${status.id}
size: ${tweet.size()}""")
