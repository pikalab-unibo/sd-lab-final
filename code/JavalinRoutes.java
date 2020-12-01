import io.javalin.Javalin;

class Service {
    private Javalin server = Javalin.create();

    public void start(int port) {
        server.start(port);

        server.HTTP_METHOD("/path/to/:resourceId", ctx -> {
            // handle http requests here
        });
    }
}