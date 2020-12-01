HttpClient client = HttpClient.newBuilder()
/* optional */  .version(Version.HTTP_2)
/* optional */  .followRedirects(Redirect.SAME_PROTOCOL)
/* optional */  .proxy(ProxySelector.of(new InetSocketAddress("www-proxy.com", 8080)))
/* optional */  .authenticator(Authenticator.getDefault())
/* MANDATORY */ .build();

// or simply:
HttpClient client = HttpClient.newHttpClient();