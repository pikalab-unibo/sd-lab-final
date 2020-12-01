var url = URI.create("http://www.unibo.it/departements/disi/phd-students/");

var body = "{\"name\": \"Giovanni Ciatto\", \"email\": \"g.ciatto@unibo.it\"}";

HttpRequest request = HttpRequest.newBuilder()
    .uri(url) // specify the request's URL
    .timeout(Duration.ofMinutes(1)) // sets a timeout for response
    .header("Content-Type", "application/json") // adds an header
    .POST(BodyPublishers.ofString(body)) // specify method and body
    .build(); // actually builds the request