public class FeeManagment {
    public int juniorPrice = 1000;
    public int seniorPrice = 1600;
    public int passivePrice = 500;
    public int elderDiscount = 25;

    public int getJuniorPrice() {
        return juniorPrice;
    }

    public int getSeniorPrice() {
        return seniorPrice;
    }

    public int getPassivePrice() {
        return passivePrice;
    }

    public int getElderDiscount() {
        return elderDiscount;
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

    public void setElderDiscount(int elderDiscount) {
        this.elderDiscount = elderDiscount;
    }

    public void printHoldPayments() {
        Dolphin.MessagesHandler.message("Printing all who didn't pay");
    }

    public void proceedPayment(Swimmer mySwimmer) {
        if ("PASSIVE".equals(mySwimmer.getMembership())) {
            Dolphin.MessagesHandler
                    .message("YOU HAVE A PASSIVE MEMBERSHIP, YOUR YEARLY PRICE IS: " + getPassivePrice() + " DKK");
            Dolphin.Menu.confirmMenu(mySwimmer);
        } else {
            if (mySwimmer.getAge() < 18) {
                Dolphin.MessagesHandler
                        .message("YOU ARE A JUNIOR SWIMMER, YOUR YEARLY PRICE IS: " + getJuniorPrice() + " DKK");
                Dolphin.Menu.confirmMenu(mySwimmer);
            } else if (mySwimmer.getAge() >= 60) {
                Dolphin.MessagesHandler.message(
                        "YOU ARE AN ELDER SWIMMER YOU HAVE " + getElderDiscount() + "% DISCOUNT, YOUR YEARLY PRICE IS: "
                                + (getSeniorPrice() - ((getSeniorPrice() / 100) * getElderDiscount())) + " DKK");
                Dolphin.Menu.confirmMenu(mySwimmer);
            } else {
                Dolphin.MessagesHandler
                        .message("YOU ARE AN SENIOR SWIMMER, YOUR YEARLY PRICE IS: " + getSeniorPrice() + " DKK");
                Dolphin.Menu.confirmMenu(mySwimmer);
            }
        }
    }
}
