public abstract class Capsule {
    private String nom;
    private boolean habitee;
    private int occupantsMax;
    private double masse;
    private double prix;

    public Capsule(String nom, boolean habitee, int occupantsMax, double masse, double prix) {
        this.nom = nom;
        this.habitee = habitee;
        this.occupantsMax = occupantsMax;
        this.masse = masse;
        this.prix = prix;
    }

    // Méthode abstraite à redéfinir dans chaque sous-classe
    public abstract String getDescription();

    // Getters
    public String getNom() { return nom; }
    public boolean isHabitee() { return habitee; }
    public int getOccupantsMax() { return occupantsMax; }
    public double getMasse() { return masse; }
    public double getPrix() { return prix; }
}