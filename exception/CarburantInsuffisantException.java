public class CarburantInsuffisantException extends Exception {

    private final double carburantNecessaire;
    private final double carburantMax;

    public CarburantInsuffisantException(double carburantNecessaire, double carburantMax) {
        super("Carburant insuffisant : " + carburantNecessaire + "t nécessaires, " + carburantMax + "t disponibles");
        this.carburantNecessaire = carburantNecessaire;
        this.carburantMax = carburantMax;
    }

    public double getCarburantNecessaire() { return carburantNecessaire; }
    public double getCarburantMax() { return carburantMax; }
}