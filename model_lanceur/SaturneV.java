public class SaturneV extends Lanceur {


    public SaturneV() {
        super("Saturne V", 2700, 140, 0, true, 1500);
    }

    @Override
    public double calculerPousseeMax() {
        return 34000;
    }

    @Override
    public String toString() {
        return "Saturne V | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}