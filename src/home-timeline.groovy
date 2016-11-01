// ホームタイムライン

def twitter = TwitterService.newTwitter()

def homeTimeline = twitter.homeTimeline

homeTimeline.each { status ->
  println('==================================================================')
  println("""\
  [${status.createdAt}], status = ${status.id}
    ${status.text}
""".trim())
  println()
}
