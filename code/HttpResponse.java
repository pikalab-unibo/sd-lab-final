HttpClient client = /* ... */;

HttpRequest request = /* ... */;

var resPromise = client.sendAsync(request, BodyHandlers.ofString())
// type of resPromise is CompletableFuture<HttpResponse<String>>
// where String is the type of the response body

resPromise.thenAccept(response -> {
        if (response.statusCode() == 200) {
            String body = response.body();
            // handle body
        } else {
            // handle exceptional case
        }
    });

resPromise.join(); // to await for response (optinal)