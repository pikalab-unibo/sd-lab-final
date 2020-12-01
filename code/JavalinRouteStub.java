server.httpMethod("/path/to/:resourceId", this::onHttpMethod);

private void onHttpMethodStub(Context ctx) throws Exception {
  String resourceId = ctx.pathParam("resourceId");
  String param = ctx.queryParam("param");
  Integer intParam = ctx.queryParam("intParam", Integer.class).get(); // automatically throws BadRequestResponse if not Integer
  String body = ctx.body();

  if (param == null || intParam == null || body == null)
    throw new BadRequestResponse("Missing request field");

  try {
    String inputMimeType = ctx.contentType();
    var bodyValue = deserialise(body, inputMimeType, TYPE_1.class);
  } catch (/* some deserialisazion error */) {
    throw new BadRequestResponse("Cannot deserialise body");
  }

  CompletableFuture<TYPE_2> result = computeResultAsync(
      resourceId, queryParam, intQueryParam, bodyValue
  );

  String outputMimeType = ctx.header("Accept");
  ctx.contentType(outputMimeType)
     .result(
        result.thenApply(res -> serialise(res, outputMimeType))
     );
}