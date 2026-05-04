public abstract class Lanceur {
    private final String nom;
    private final double carburantMax;
    private final double chargeUtileMax;
    private final int boostersMax;
    private final boolean habite;
    private final double prix;

    // Constructeur séparé de la méthode abstraite
    public Lanceur(String nom, double carburantMax, double chargeUtileMax,
                   int boostersMax, boolean habite, double prix) {
        this.nom = nom;
        this.carburantMax = carburantMax;
        this.chargeUtileMax = chargeUtileMax;
        this.boostersMax = boostersMax;
        this.habite = habite;
        this.prix = prix;
    }

    // Abstraite = pas de corps, juste la signature
    public abstract double calculerPousseeMax();

    // Getters
    public String getNom() { return nom; }
    public double getCarburantMax() { return carburantMax; }
    public double getChargeUtileMax() { return chargeUtileMax; }
    public int getBoostersMax() { return boostersMax; }
    public boolean isHabite() { return habite; }
    public double getPrix() { return prix; }
}