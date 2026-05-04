public class CrioLifeEuropa extends Mission {

    public CrioLifeEuropa() {
        super("CryoLife Europa", 628000000, false, 0.000008, 730);
    }

    @Override
    public double calculerCarburantNecessaire(double masseFusee) {
        return (masseFusee * getDistance() * getCoefficientCarburant()) / 1000;
    }

    @Override
    public String toString() {
        return "CryoLife Europa | Distance: " + getDistance() + "km | Habitée: non";
    }
}