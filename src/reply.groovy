// リプライ

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Grab('org.twitter4j:twitter4j-core:4.0.5')
import twitter4j.StatusUpdate

def targetStatusId = 

def targetIds = ''

def replyText = """\

""".trim()

def tweet = """\
${targetIds ? targetIds + ' ' : ''}${replyText}
""".trim()

def now = LocalDateTime.now()

def twitter = TwitterService.newTwitter()

def statusUpdate = new StatusUpdate(tweet)
statusUpdate.inReplyToStatusId = targetStatusId

def status = twitter.updateStatus(statusUpdate)

println("""\
[Reply] ${now.format(DateTimeFormatter.ofPattern('yyyy-MM-dd HH:mm:ss'))} target: ${targetStatusId}
statusId: ${status.id}
size: ${tweet.size()}""")
