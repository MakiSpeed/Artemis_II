public class Booster {
    private final String nom;
    private final double pousseekN;
    private final double masse;
    private final double prix;

    public Booster(String nom, double pousseekN, double masse, double prix) {
        this.nom = nom;
        this.pousseekN = pousseekN;
        this.masse = masse;
        this.prix = prix;
    }

    // Getters
    public String getNom() { return nom; }
    public double getPousseekN() { return pousseekN; }
    public double getMasse() { return masse; }
    public double getPrix() { return prix; }

    @Override
    public String toString() {
        return nom + " | Poussée: " + pousseekN + "kN | Masse: " + masse + "t | Prix: " + prix + "M€";
    }
}