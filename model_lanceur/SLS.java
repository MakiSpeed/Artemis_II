public abstract class SLS extends lanceur {
    public SLS(String nom, double carburantMax, double chargeUtileMax, double boostersMax, int habite, double prix) {
        super(nom, carburantMax, chargeUtileMax, boostersMax, habite, prix);
    }

    @Override
    public void calculerPousseeMax() {
        // Implémentation spécifique pour SLS
    }
}