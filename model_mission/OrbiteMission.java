public class OrbiteMission extends Mission {

    public OrbiteMission() {
        super("Orbite Terrestre", 400, false, 1.0, 1);
    }

    @Override
    public double calculerCarburantNecessaire(double masseFusee) {
        return (masseFusee * getDistance() * getCoefficientCarburant()) / 1000;
    }

    @Override
    public String toString() {
        return "Orbite Mission | Distance: " + getDistance() + "km | Habitée: " + isHabitee();
    }
}