public class ISSMission extends Mission {

    public ISSMission() {
        super("ISS", 400, true, 1.2, 5);
    }

    @Override
    public double calculerCarburantNecessaire(double masseFusee) {
        return (masseFusee * getDistance() * getCoefficientCarburant()) / 1000;
    }

    @Override
    public String toString() {
        return "ISS Mission | Distance: " + getDistance() + "km | Habitée: " + isHabitee();
    }
}