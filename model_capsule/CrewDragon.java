public class CrewDragon extends Capsule {

    public CrewDragon() {
        super("Crew Dragon", true,  7, 12.0, 150);
    }

    @Override
    public String getDescription() {
        return "Capsule habitée SpaceX, 7 occupants max, réutilisable";
    }

    @Override
    public String toString() {
        return "CrewDragon | Masse: " + getMasse() + "t | Prix: " + getPrix() + "M€";
    }
}