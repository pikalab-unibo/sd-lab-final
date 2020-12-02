package sd.lab.agency;

public interface Environment {

  // ... other stuff

  static Environment distributed(String name, String host, int port) {
    return new DistributedEnvironment(name, host, port);   
  }
}