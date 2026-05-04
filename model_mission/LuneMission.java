public class LuneMission extends Mission {

    public LuneMission() {
        super("Lune", 400000, true, 0.005, 9);
    }

    @Override
    public double calculerCarburantNecessaire(double masseFusee) {
        return (masseFusee * getDistance() * getCoefficientCarburant()) / 1000;
    }

    @Override
    public String toString() {
        return "Lune Mission | Distance: " + getDistance() + "km | Habitée: " + isHabitee();
    }
}