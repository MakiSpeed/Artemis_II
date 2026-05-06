
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Simulateur simulateur = Simulateur.getInstance();
    static Fusee fuseeActuelle = null;
    static Mission missionActuelle = null;

    public static void main(String[] args) {

        // Chargement historique au démarrage
        Persistence persistence = new Persistence();
        System.out.println("=== ARTEMIS II — Simulateur de lancement spatial ===\n");

        int choix = -1;
        while (choix != 5) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Configurer une fusée");
            System.out.println("2. Choisir une mission");
            System.out.println("3. Lancer la simulation");
            System.out.println("4. Afficher l'historique");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");

            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, entrez un chiffre.");
                continue;
            }

            switch (choix) {
                case 1 ->
                    configurerFusee();
                case 2 ->
                    choisirMission();
                case 3 ->
                    lancerSimulation(persistence);
                case 4 ->
                    persistence.afficherHistorique();
                case 5 ->
                    System.out.println("Au revoir !");
                default ->
                    System.out.println("Choix invalide.");
            }
        }
    }

    static void configurerFusee() {
        // Choix lanceur
        System.out.println("\n--- LANCEURS DISPONIBLES ---");
        List<Lanceur> lanceurs = simulateur.getLanceurs();
        for (int i = 0; i < lanceurs.size(); i++) {
            System.out.println((i + 1) + ". " + lanceurs.get(i));
        }
        System.out.print("Choisissez un lanceur : ");
        int choixLanceur = Integer.parseInt(scanner.nextLine()) - 1;
        Lanceur lanceur = lanceurs.get(choixLanceur);

        // Choix capsule
        System.out.println("\n--- CAPSULES DISPONIBLES ---");
        List<Capsule> capsules = simulateur.getCapsules();
        for (int i = 0; i < capsules.size(); i++) {
            System.out.println((i + 1) + ". " + capsules.get(i));
        }
        System.out.print("Choisissez une capsule : ");
        int choixCapsule = Integer.parseInt(scanner.nextLine()) - 1;
        Capsule capsule = capsules.get(choixCapsule);

        fuseeActuelle = new Fusee(lanceur, capsule);

        // Ajout boosters
        if (lanceur.getBoostersMax() > 0) {
            System.out.println("\n--- BOOSTERS DISPONIBLES ---");
            List<Booster> boosters = simulateur.getBoosters();
            for (int i = 0; i < boosters.size(); i++) {
                System.out.println((i + 1) + ". " + boosters.get(i));
            }
            System.out.println("0. Pas de booster");
            System.out.print("Choisissez un booster : ");
            int choixBooster = Integer.parseInt(scanner.nextLine());
            if (choixBooster > 0) {
                System.out.print("Combien ? (max " + lanceur.getBoostersMax() + ") : ");
                int quantite = Integer.parseInt(scanner.nextLine());
                fuseeActuelle.ajouterBooster(boosters.get(choixBooster - 1), quantite);
            }
        }

        System.out.println("\n Fusée configurée : " + fuseeActuelle);
    }

    static void choisirMission() {
        System.out.println("\n--- MISSIONS DISPONIBLES ---");
        List<Mission> missions = simulateur.getMissions();
        for (int i = 0; i < missions.size(); i++) {
            System.out.println((i + 1) + ". " + missions.get(i));
        }
        System.out.print("Choisissez une mission : ");
        int choix = Integer.parseInt(scanner.nextLine()) - 1;
        missionActuelle = missions.get(choix);
        System.out.println(" Mission choisie : " + missionActuelle);
    }

    static void lancerSimulation(Persistence persistence) {
        if (fuseeActuelle == null) {
            System.out.println(" Configurez d'abord une fusée !");
            return;
        }
        if (missionActuelle == null) {
            System.out.println(" Choisissez d'abord une mission !");
            return;
        }

        try {
                Lancement lancement = simulateur.effectuerLancement(fuseeActuelle, missionActuelle);
                System.out.println("\n=== RÉSULTAT ===");
                System.out.println(lancement);
                persistence.sauvegarder(simulateur.getHistorique());
            } catch (CarburantInsuffisantException e) {
                System.out.println(" ÉCHEC : " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" Erreur : " + e.getMessage());
            }
        }

    }