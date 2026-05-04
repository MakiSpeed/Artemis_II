public class MarsMission extends Mission {

    public MarsMission() {
        super("Mars", 225000000, true, 0.000015, 450);
    }

    @Override
    public double calculerCarburantNecessaire(double masseFusee) {
        return (masseFusee * getDistance() * getCoefficientCarburant()) / 1000;
    }

    @Override
    public String toString() {
        return "Mars Mission | Distance: " + getDistance() + "km | Habitée: " + isHabitee();
    }
}