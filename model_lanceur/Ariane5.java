public class Ariane5 extends Lanceur {

    // Pas de nouveaux attributs — ils sont dans Lanceur

    public Ariane5() {
        // Valeurs directement depuis l'annexe du sujet
        super("Ariane 5",  700,  20, 2, false, 180);
    }

    @Override
    public double calculerPousseeMax() {
        //  kN — moteur Vulcain + 2 boosters EAP
        return 13000;
    }

    @Override
    public String toString() {
        return "Ariane5 | Carburant max: " + getCarburantMax() + "t | Prix: " + getPrix() + "M€";
    }
}