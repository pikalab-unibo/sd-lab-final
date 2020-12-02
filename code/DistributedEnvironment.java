package sd.lab.agency.impl;

public class DistributedEnvironment extends LocalEnvironment {

  private final String hostname;
  private final int port;

  public DistributedMultiThreadedEnvironment(String name, String hostname, int port) {
    super(name);
    this.hostname = hostname;
    this.port = port;
  }

  @Override
  protected TextualSpace newTextualSpace(String name) {
    return TextualSpace.remote(hostname, port, name);
  }
}