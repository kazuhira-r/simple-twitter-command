// ツイート

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def tweet = '''\

'''.trim()

def now = LocalDateTime.now()

def twitter = TwitterService.newTwitter()

def status = twitter.updateStatus(tweet)

println("""\
[Tweet] ${now.format(DateTimeFormatter.ofPattern('yyyy-MM-dd HH:mm:ss'))}
statusId: ${status.id}
size: ${tweet.size()}""")
