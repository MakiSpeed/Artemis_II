public abstract class Lanceur {
    private String nom;
    private double carburantMax;
    private double chargeUtileMax;
    private int boostersMax;
    private boolean habite;
    private double prix;

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