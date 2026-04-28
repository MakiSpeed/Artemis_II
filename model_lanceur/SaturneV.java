public class SaturneV extends Lanceur {

    // Pas de nouveaux attributs — ils sont dans Lanceur

    public SaturneV() {
        // Valeurs directement depuis l'annexe du sujet
        super("Saturne V", 2700, 140, 0, true, 1500);
    }

    @Override
    public double calculerPousseeMax() {
        // La Saturne V a 5 moteurs F-1, ~34 000 kN au total
        return 34000;
    }

    @Override
    public String toString() {
        return "Saturne V | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}