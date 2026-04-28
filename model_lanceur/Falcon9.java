public class Falcon9 extends Lanceur {

    // Pas de nouveaux attributs — ils sont dans Lanceur

    public Falcon9() {
        // Valeurs directement depuis l'annexe du sujet
        super("Falcon 9",  500,  22, 0, true,   60);
    }

    @Override
    public double calculerPousseeMax() {
        //  kN — 9 moteurs Merlin
        return 7600;
    }

    @Override
    public String toString() {
        return "Falcon9 | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}