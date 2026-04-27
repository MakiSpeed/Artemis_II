public abstract class lanceur {
    private String nom;
    private double carburantMax;
    private double chargeUtileMax;
    private double boostersMax;
    private double habite;
    private double prix;

    public abstract void calculerPousseeMax() {
        this.nom = nom;
        this.carburantMax = carburantMax;
        this.chargeUtileMax = chargeUtileMax;
        this.boostersMax = boostersMax;
        this.habite = habite;
        this.prix = prix;
    }
}