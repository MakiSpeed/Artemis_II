public abstract class Mission {

    private String nom;
    private double distance;
    private boolean habite;
    private double coefficientCarburant;


    public abstract void calculerCarburantNecessaire(double masseFusee, double distance); {

    }
}