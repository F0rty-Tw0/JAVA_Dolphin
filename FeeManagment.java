import java.util.*; // for scanner

public class FeeManagment {
    private static Scanner input = new Scanner(System.in);

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

    public void changePassivePrice() {
        Dolphin.MessagesHandler.message("CURRENT PASSIVE PRICE IS: " + getPassivePrice() + " DKK");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.MessagesHandler.message("ENTER A NEW PASSIVE PRICE: ");
                int inputField = input.nextInt();
                setPassivePrice(inputField);
                Dolphin.MessagesHandler.message("THE PRICE WAS CHANGED SUCCESSFUL TO: " + inputField + " DKK");
                input.nextLine();
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    public void changeJuniorPrice() {
        Dolphin.MessagesHandler.message("CURRENT JUNIOR PRICE IS: " + getJuniorPrice() + " DKK");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.MessagesHandler.message("ENTER A NEW JUNIOR PRICE: ");
                int newPrice = input.nextInt();
                setJuniorPrice(newPrice);
                Dolphin.MessagesHandler.message("THE PRICE WAS CHANGED SUCCESSFUL TO: " + newPrice + " DKK");
                input.nextLine();
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    public void changeSeniorPrice() {
        Dolphin.MessagesHandler.message("CURRENT SENIOR PRICE IS: " + getSeniorPrice() + " DKK");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.MessagesHandler.message("ENTER A NEW SENIOR PRICE: ");
                int newPrice = input.nextInt();
                setSeniorPrice(newPrice);
                Dolphin.MessagesHandler.message("THE PRICE WAS CHANGED SUCCESSFUL TO: " + newPrice + " DKK");
                input.nextLine();
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    public void changeElderDiscount() {
        Dolphin.MessagesHandler.message("CURRENT ELDER DISCOUNT IS: " + getElderDiscount() + " %");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.MessagesHandler.message("ENTER A NEW ELDER DISCOUNT: ");
                int newPrice = input.nextInt();
                setElderDiscount(newPrice);
                Dolphin.MessagesHandler.message("THE DISCOUNT WAS CHANGED SUCCESSFUL TO: " + newPrice + " %");
                input.nextLine();
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }
}
