@Grab('org.twitter4j:twitter4j-core:4.0.5')
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

class Configuration {
  static def oauthKeys = [
    consumerKey: "",
    consumerSecret: "",
    accessToken: "",
    accessTokenSecret: ""
  ]

  static def proxySettings = [
    httpProxyHost: "",
    httpProxyPort: "",
    httpsProxyHost: "",
    httpsProxyPort: ""
  ]

  static def enabledProxyIfNeeded() {
    if (proxySettings.httpProxyHost && proxySettings.httpProxyPort) {
      System.setProperty("http.proxyHost", proxySettings.httpProxyHost)
      System.setProperty("http.proxyPort", proxySettings.httpProxyPort)
    }

    if (proxySettings.httpsProxyHost && proxySettings.httpsProxyPort) {
      System.setProperty("https.proxyHost", proxySettings.httpsProxyHost)
      System.setProperty("https.proxyPort", proxySettings.httpsProxyPort)
    }
  }

  static def newTwitter() {
    enabledProxyIfNeeded()

    /*
    def configurationBuilder = new ConfigurationBuilder();

    configurationBuilder
      .setOAuthConsumerKey(oauthKeys.consumerKey)
      .setOAuthConsumerSecret(oauthKeys.consumerSecret)
      .setOAuthAccessToken(oauthKeys.accessToken)
      .setOAuthAccessTokenSecret(oauthKeys.accessTokenSecret)

    def twitterFactory = new TwitterFactory(configurationBuilder.build())
    */
    def twitterFactory = new TwitterFactory()
    twitterFactory.getInstance()
  }
}