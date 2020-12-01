import io.javalin.Javalin;
import io.javalin.http.Context;

class Service {
  private Javalin server = Javalin.create();

  public void start(int port) {
    server.start(port);

    server.HTTP_METHOD("/path/to/:resourceId", this::onHttpMethod);
  }

  private void onHttpMethod(Context ctx) throws Exception {
    // handle http requests here
  }
}