public class Falcon9 extends Lanceur {


    public Falcon9() {
        super("Falcon 9",  500,  22, 0, true,   60);
    }

    @Override
    public double calculerPousseeMax() {
        return 7600;
    }

    @Override
    public String toString() {
        return "Falcon9 | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}