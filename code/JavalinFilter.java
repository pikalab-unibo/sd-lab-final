Javalin server = Javalin.create().start(8080);

server.before("/partial/path/to/*", ctx -> {
    // do something BEFORE each request
    // directed towards any path starting by
    // /partial/path/to/ is executed
});

