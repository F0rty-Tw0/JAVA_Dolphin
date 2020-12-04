public class Treasurer extends Administrator {

    public Treasurer(String name) {
        super(name);
    }

    public void printPrices() {
        Dolphin.MessagesHandler.message("JUNIOR PRICE IS: " + Dolphin.FeeManagment.getJuniorPrice() + " DKK");
        Dolphin.MessagesHandler.message("SENIOR PRICE IS: " + Dolphin.FeeManagment.getSeniorPrice() + " DKK");
        Dolphin.MessagesHandler.message("PASSIVE PRICE IS: " + Dolphin.FeeManagment.getPassivePrice() + " DKK");
        Dolphin.MessagesHandler.message("ELDER DISCOUNT IS: " + Dolphin.FeeManagment.getElderDiscount() + "%");
    }

    public void printHoldPayments() {
        int i = 0;
        if (Dolphin.mySwimmers.size() == 0) {
            Dolphin.MessagesHandler.message("NO SWIMMER AVAILABLE, TRY TO ADD SOME.");
        } else {
            Dolphin.MessagesHandler.message("PRINTING THE SWIMMERS THAT DIDN'T PAID YET...\n");
        }
        for (Swimmer Swimmer : Dolphin.mySwimmers) {
            if (!Swimmer.getPayed()) {
                i++;
                Dolphin.MessagesHandler.message("NUMBER: " + i + " | NAME: " + Swimmer.getName() + " | SURENAME: "
                        + Swimmer.getSurename() + " | MEMBERSHIP: " + Swimmer.getMembership() + " | DISCIPLINE: "
                        + Swimmer.getDiscipline() + " | STATUS: " + Swimmer.getStatus() + " | ACTIVITY: "
                        + Swimmer.getActivity() + " | AGE: " + Swimmer.getAge() + " | PAYED: " + Swimmer.getPayed()
                        + " | TEAM: " + Swimmer.getTeam() + " | COACH: " + Swimmer.getCoach() + " | RESULT: "
                        + Swimmer.getResult());
            }
        }
    }
}