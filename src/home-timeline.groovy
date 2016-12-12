// ホームタイムライン

def twitter = TwitterService.newTwitter()

def homeTimeline = twitter.homeTimeline

homeTimeline.each { status ->
  println('==================================================================')
  println("""\
  [${status.createdAt}], status = ${status.id}
  from: ${status.user.name} | screenName: @${status.user.screenName}
    ${status.text}
""".trim())
  println()
}
