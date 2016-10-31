// リプライ

def twitter = TwitterService.newTwitter()

twitter.mentionsTimeline.each { status ->
  println('==================================================================')
  println("""\
  [${status.createdAt}], status = ${status.id}
  from: ${status.user.name} | screenName: @${status.user.screenName}
    ${status.text}
""".trim())
  println()
}
