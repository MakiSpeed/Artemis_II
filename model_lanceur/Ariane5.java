public abstract class Ariane5 extends lanceur {
    public Ariane5(String nom, double carburantMax, double chargeUtileMax, double boostersMax, int habite, double prix) {
        super(nom, carburantMax, chargeUtileMax, boostersMax, habite, prix);
    }

    @Override
    public void calculerPousseeMax() {
        // Implémentation spécifique pour Ariane 5
    }
}