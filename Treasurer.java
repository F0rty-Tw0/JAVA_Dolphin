public class Treasurer extends Administrator {

    public Treasurer(String name) {
        super(name);
    }

    public void printPrices(FeeManagment FeeManagment) {
        Dolphin.MessagesHandler.message("JUNIOR PRICE IS: " + FeeManagment.getJuniorPrice() + " DKK");
        Dolphin.MessagesHandler.message("SENIOR PRICE IS: " + FeeManagment.getSeniorPrice() + " DKK");
        Dolphin.MessagesHandler.message("PASSIVE PRICE IS: " + FeeManagment.getPassivePrice() + " DKK");
        Dolphin.MessagesHandler.message("ELDER DISCOUNT IS: " + FeeManagment.getElderDiscount() + "%");
    }

    public void printHoldPayments() {
        Dolphin.MessagesHandler.message("Printing all who didn't pay");
    }
}