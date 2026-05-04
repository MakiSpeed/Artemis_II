public abstract class Mission {

    private final String nom;
    private final double distance;
    private final boolean habitee;
    private final double coefficientCarburant;
    private final double duree;

    public Mission(String nom, double distance, boolean habitee, double coefficientCarburant, double duree) {
        this.nom = nom;
        this.distance = distance;
        this.habitee = habitee;
        this.coefficientCarburant = coefficientCarburant;
        this.duree = duree;
    }

    public abstract double calculerCarburantNecessaire(double masseFusee);

    // Getters
    public String getNom() { return nom; }
    public double getDistance() { return distance; }
    public boolean isHabitee() { return habitee; }
    public double getCoefficientCarburant() { return coefficientCarburant; }
    public double getDuree() { return duree; }
}