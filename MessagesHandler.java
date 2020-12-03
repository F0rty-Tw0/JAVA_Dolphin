public class MessagesHandler {
    public boolean sentinel = false;

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
        message("YOU ENTERED A WRONG INPUT!");
    };
}
