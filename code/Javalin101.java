import io.javalin.Javalin;

public class HelloWorld {
  public static void main(String[] args) {
    var server = Javalin.create().start(8080);

    // the server is now listening for HTTP requests on port 8080

    // dynamically configure routes, e.g.
    server.get("/", ctx -> ctx.result("Hello World"));

    server.stop();

    // the server is not listening anymore
  }
}