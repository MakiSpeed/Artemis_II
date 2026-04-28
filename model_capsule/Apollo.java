public class Apollo extends Capsule {

    public Apollo() {
        super("Apollo", true, 3, 5.6, 200);
    }

    @Override
    public String getDescription() {
        return "Capsule habitée, 3 occupants max, utilisée pour les missions lunaires Apollo";
    }

    @Override
    public String toString() {
        return "Apollo | Masse: " + getMasse() + "t | Prix: " + getPrix() + "M€";
    }
}