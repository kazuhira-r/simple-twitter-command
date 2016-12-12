// リプライ

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def targetStatusId = 

def targetIds = ''

def replyText = """\

""".trim()

def tweet = """\
${targetIds ? targetIds + ' ' : ''}${replyText}
""".trim()

def now = LocalDateTime.now()

def twitter = TwitterService.newTwitter()

def statusUpdate = TwitterService.newStatusUpdate(tweet)
statusUpdate.inReplyToStatusId = targetStatusId

def status = twitter.updateStatus(statusUpdate)

println("""\
[Reply] ${now.format(DateTimeFormatter.ofPattern('yyyy-MM-dd HH:mm:ss'))} target: ${targetStatusId}
statusId: ${status.id}
size: ${tweet.size()}""")
