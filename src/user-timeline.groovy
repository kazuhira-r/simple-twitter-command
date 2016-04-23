def twitter = Configuration.newTwitter()

twitter.userTimeline.each { status ->
  println('==================================================================')
  println("""\
  [${status.createdAt}], status = ${status.id}
    ${status.text}
""".trim())
  println()
}
