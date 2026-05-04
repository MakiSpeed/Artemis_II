public class Main {
    public static void main(String[] args) {

        // Test lanceurs
        Lanceur l = new SaturneV();
        System.out.println(l);


        Capsule c = new Orion();
        System.out.println(c);


        Mission m = new LuneMission();
        System.out.println(m);


        Booster b = new Booster("EAP (Ariane)", 6470, 270, 30);
        System.out.println(b);
    }
}