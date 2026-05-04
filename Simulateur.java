import java.util.ArrayList;
import java.util.List;

public class Simulateur {

    // Singleton
    private static Simulateur instance;

    // Constantes
    private static final double PRIX_KEROSENE_PAR_TONNE = 1200;
    private static final double PROBA_ECHEC = 0.05;

    // Catalogues
    private List<Lanceur> lanceurs;
    private List<Capsule> capsules;
    private List<Booster> boosters;
    private List<Mission> missions;
    private final List<Lancement> historique;

    // Constructeur privé — singleton
    private Simulateur() {
        historique = new ArrayList<>();
        initialiserCatalogues();
    }

    // getInstance — singleton
    public static Simulateur getInstance() {
        if (instance == null) {
            instance = new Simulateur();
        }
        return instance;
    }

    private void initialiserCatalogues() {
        // Lanceurs
        lanceurs = new ArrayList<>();
        lanceurs.add(new SaturneV());
        lanceurs.add(new Ariane5());
        lanceurs.add(new Falcon9());
        lanceurs.add(new SLS());

        // Capsules
        capsules = new ArrayList<>();
        capsules.add(new Orion());
        capsules.add(new CrewDragon());
        capsules.add(new Apollo());
        capsules.add(new CargoDragon());

        // Boosters
        boosters = new ArrayList<>();
        boosters.add(new Booster("EAP (Ariane)", 6470, 270, 30));
        boosters.add(new Booster("SRB (Shuttle)", 12500, 590, 55));
        boosters.add(new Booster("BE-3", 490, 25, 12));

        // Missions
        missions = new ArrayList<>();
        missions.add(new OrbiteMission());
        missions.add(new ISSMission());
        missions.add(new LuneMission());
        missions.add(new MarsMission());
        missions.add(new CrioLifeEuropa());
    }

    public Lancement effectuerLancement(Fusee fusee, Mission mission) throws Exception {

        // Vérification 1 — trop de boosters
        if (fusee.getBoosters().size() > fusee.getLanceur().getBoostersMax()) {
            return new Lancement(fusee, mission, false, "Trop de boosters", 0);
        }

        // Vérification 2 — surcharge
        if (fusee.calculerMasseTotale() > fusee.getLanceur().getChargeUtileMax()) {
            return new Lancement(fusee, mission, false, "Surcharge dépassée", 0);
        }

        // Vérification 3 — carburant
        double carburant = mission.calculerCarburantNecessaire(fusee.calculerMasseTotale());
        if (carburant > fusee.getLanceur().getCarburantMax()) {
            return new Lancement(fusee, mission, false, "Carburant insuffisant", 0);
        }

        // Vérification 4 — capsule compatible
        if (mission.isHabitee() && !fusee.getCapsule().isHabitee()) {
            return new Lancement(fusee, mission, false, "Capsule incompatible avec une mission habitée", 0);
        }

        // Aléa de lancement
        double alea = Math.random();
        if (alea < PROBA_ECHEC) {
            return new Lancement(fusee, mission, false, "Anomalie technique imprévue", 0);
        }

        // Calcul coût total
        double coutTotal = fusee.calculerCoutTotal() + (carburant * PRIX_KEROSENE_PAR_TONNE);

        Lancement lancement = new Lancement(fusee, mission, true, "Succès", coutTotal);
        historique.add(lancement);
        return lancement;
    }

    // Getters
    public List<Lanceur> getLanceurs() { return lanceurs; }
    public List<Capsule> getCapsules() { return capsules; }
    public List<Booster> getBoosters() { return boosters; }
    public List<Mission> getMissions() { return missions; }
    public List<Lancement> getHistorique() { return historique; }
}