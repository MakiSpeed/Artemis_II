public abstract class Falcon9 extends lanceur {
    public Falcon9(String nom, double carburantMax, double chargeUtileMax, double boostersMax, int habite, double prix) {
        super(nom, carburantMax, chargeUtileMax, boostersMax, habite, prix);
    }

    @Override
    public void calculerPousseeMax() {
        // Implémentation spécifique pour Falcon 9
    }
}