// ユーザータイムライン

def screenName
if (args.size() > 0) {
  screenName = args[0]
}

def twitter = TwitterService.newTwitter()

def userTimeline
if (screenName) {
  userTimeline = twitter.getUserTimeline(screenName)
} else {
  userTimeline = twitter.userTimeline
}

userTimeline.each { status ->
  println('==================================================================')
  println("""\
  [${status.createdAt}], status = ${status.id}
    ${status.text}
""".trim())
  println()
}
