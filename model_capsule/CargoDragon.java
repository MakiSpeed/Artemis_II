public class CargoDragon extends Capsule {

    public CargoDragon() {
        super("Cargo Dragon", false, 0, 9.5, 100);
    }

    @Override
    public String getDescription() {
        return "Capsule cargo non habitée, transport de fret uniquement";
    }

    @Override
    public String toString() {
        return "CargoDragon | Masse: " + getMasse() + "t | Prix: " + getPrix() + "M€";
    }
}