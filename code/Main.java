public class Main {
  public static void main(String[] args) throws Exception {
    var host = args[0];
    var port = Integer.parseInt(args[1]);
    var envName = args[2];

    var environment = Environment.distributed(envName, host, port);

    environment.setLoggingEnabled(false);

    var agent1 = environment.createAgent(Agent1.class, "agent1");
    var agent2 = environment.createAgent(Agent2.class, "agent2");

    agent1.start();   agent2.start();

    agent1.await();   agent2.await();
  }
}