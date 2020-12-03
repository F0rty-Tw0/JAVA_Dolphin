import java.util.*; // for scanner

public class MessagesHandler {
    boolean sentinel = false;
    Scanner input = new Scanner(System.in);

    public Boolean getSentinel() {
        return sentinel;
    }

    public void setSentinel(boolean sentinel) {
        this.sentinel = sentinel;
    }

    // Message printer
    public void message(String message) {
        System.out.print("\n" + message);
    }

    // Error printer
    public void handleError() {
        sentinel = true;
        message("You entered a wrong input!!!");
    };
}
