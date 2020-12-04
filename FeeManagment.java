public class FeeManagment {
    private static MessagesHandler MessagesHandler = new MessagesHandler();
    private static Menu Menu = new Menu();
    public int juniorPrice = 1000;
    public int seniorPrice = 1600;
    public int passivePrice = 500;

    public int getJuniorPrice() {
        return juniorPrice;
    }

    public int getSeniorPrice() {
        return seniorPrice;
    }

    public int getPassivePrice() {
        return passivePrice;
    }

    public void setJuniorPrice(int juniorPrice) {
        this.juniorPrice = juniorPrice;
    }

    public void setSeniorPrice(int seniorPrice) {
        this.seniorPrice = seniorPrice;
    }

    public void setPassivePrice(int passivePrice) {
        this.passivePrice = passivePrice;
    }

    public void printHoldPayments() {
        MessagesHandler.message("Printing all who didn't pay");
    }

    public void proceedPayment(Swimmer mySwimmer) {
        if ("PASSIVE".equals(mySwimmer.getMembership())) {
            MessagesHandler
                    .message("YOU HAVE A PASSIVE MEMBERSHIP, YOUR YEARLY PRICE IS: " + getPassivePrice() + " DKK");
            Menu.confirmMenu(mySwimmer);
        } else {
            if (mySwimmer.getAge() < 18) {
                MessagesHandler.message("YOU ARE A JUNIOR SWIMMER, YOUR YEARLY PRICE IS: " + getJuniorPrice() + " DKK");
                Menu.confirmMenu(mySwimmer);
            } else if (mySwimmer.getAge() >= 60) {
                MessagesHandler.message("YOU ARE AN ELDER SWIMMER, YOUR YEARLY PRICE IS: "
                        + (getSeniorPrice() - (getSeniorPrice() * 0.25)) + " DKK");
                Menu.confirmMenu(mySwimmer);
            } else {
                MessagesHandler
                        .message("YOU ARE AN SENIOR SWIMMER, YOUR YEARLY PRICE IS: " + getSeniorPrice() + " DKK");
                Menu.confirmMenu(mySwimmer);
            }
        }
    }
}
