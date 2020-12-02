public class ChatterAgent extends AbstractAgent {

  private final String otherName;
  private AID otherAid;

  public ChatterAgent(String name, String otherName) {
    super(name);
    this.otherName = Objects.requireNonNull(otherName);
  }

  @Override
  public void setup() {
    otherAid = getEnvironment().aidOf(otherName);
    System.out.printf("%s agent started.\n", getAID());
    addBehaviour(echoMyMessages());
    addBehaviour(listenOtherMessages());
  }

  
  private Behaviour echoMyMessages() {
    return readLine(System.in, this::onLineRead).repeatForEver();
  }

  private Behaviour listenOtherMessages() {
    return receiveAnyMessageFromAnyone(this::onMessageReceived).repeatForEver();
  }

  private void onLineRead(String line) {
    if (line.trim().startsWith(":end")) {
      addBehaviour(halt());
    } else {
      addBehaviour(send(otherAid, line));
    }
  }

  private void onMessageReceived(AID sender, String message) {
    System.out.printf("[%s] %s\n", sender, message);
  }

  private Behaviour halt() {
    return Behaviour.of(() -> System.out.println("Halted."))
                    .andThen(stopAgent());
  }
}