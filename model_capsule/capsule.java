public abstract class Capsule {
    private final String nom;
    private final boolean habitee;
    private final int occupantsMax;
    private final double masse;
    private final double prix;

    public Capsule(String nom, boolean habitee, int occupantsMax, double masse, double prix) {
        this.nom = nom;
        this.habitee = habitee;
        this.occupantsMax = occupantsMax;
        this.masse = masse;
        this.prix = prix;
    }

    public abstract String getDescription();

    // Getters
    public String getNom() { return nom; }
    public boolean isHabitee() { return habitee; }
    public int getOccupantsMax() { return occupantsMax; }
    public double getMasse() { return masse; }
    public double getPrix() { return prix; }
}