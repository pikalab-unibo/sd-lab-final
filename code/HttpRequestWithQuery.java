var baseUrl = "http://www.unibo.it/departements/disi/phd-students";

var query = "?"
        + "name=" + URLEncoder.encode("giovanni ciatto", UTF_16)
        + "&"
        + "email=" + URLEncoder.encode("g.ciatto@unibo.it", UTF_16)
        ;

var url = URI.create(baseUrl + query);

HttpRequest request = HttpRequest.newBuilder()
    .uri(url) // specify the request's URL
    .timeout(Duration.ofMinutes(1)) // sets a timeout for response
    .header("Accept", "application/json") // adds an header
    .GET() // specify method and empty body
    .build(); // actually builds the request