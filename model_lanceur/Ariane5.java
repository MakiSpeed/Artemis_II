public class Ariane5 extends Lanceur {


    public Ariane5() {
        super("Ariane 5",  700,  20, 2, false, 180);
    }

    @Override
    public double calculerPousseeMax() {
        return 13000;
    }

    @Override
    public String toString() {
        return "Ariane5 | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}