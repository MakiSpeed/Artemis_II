public class Orion extends Capsule {

    public Orion() {
        super("Orion",        true,  4, 10.4, 300);
    }

    @Override
    public String getDescription() {
        return "Capsule habitée nouvelle génération, 4 occupants max, conçue pour les missions Artemis";
    }

    @Override
    public String toString() {
        return "Orion | Masse: " + getMasse() + "t | Prix: " + getPrix() + "M€";
    }
}