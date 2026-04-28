public class SLS extends Lanceur {

    // Pas de nouveaux attributs — ils sont dans Lanceur

    public SLS() {
        // Valeurs directement depuis l'annexe du sujet
        super("SLS",      2600, 130, 2, true, 2000);
    }

    @Override
    public double calculerPousseeMax() {
        // kN — 4 moteurs RS-25 + 2 boosters SRB
        return 39000;
}


    @Override
    public String toString() {
        return "SLS | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}