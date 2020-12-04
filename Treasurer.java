public class Treasurer extends Administrator {
    public Treasurer(String name) {
        super(name);
    }

    public void printPrices(FeeManagment FeeManagment) {
        FeeManagment.getJuniorPrice();
        FeeManagment.getSeniorPrice();
        FeeManagment.getPassivePrice();
    }
}