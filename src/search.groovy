// 検索

def queryString = args[0]

def twitter = TwitterService.newTwitter()

def queryResult = twitter.search(TwitterService.newQuery(queryString))

while (true) {
  queryResult
    .tweets
    .each { status ->
      println("""\
=====
  [${status.createdAt}], status = ${status.id}
  from: ${status.user.name} | screenName: @${status.user.screenName}
    ${status.text}
""".trim())

      println()
  }

  if (queryResult.hasNext()) {
    System.console().readLine('> Enter continue...')
    queryResult = twitter.search(queryResult.nextQuery())
  } else {
    break
  }
}