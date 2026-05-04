import java.time.LocalDateTime;

public class Lancement {
    private final Fusee fusee;
    private final Mission mission;
    private final LocalDateTime date;
    private final boolean succes;
    private final String raison;
    private final double coutTotal;

    public Lancement(Fusee fusee, Mission mission, boolean succes, String raison, double coutTotal) {
        this.fusee = fusee;
        this.mission = mission;
        this.date = LocalDateTime.now();
        this.succes = succes;
        this.raison = raison;
        this.coutTotal = coutTotal;
    }

    // Getters
    public Fusee getFusee() { return fusee; }
    public Mission getMission() { return mission; }
    public LocalDateTime getDate() { return date; }
    public boolean isSucces() { return succes; }
    public String getRaison() { return raison; }
    public double getCoutTotal() { return coutTotal; }

    @Override
    public String toString() {
        return date + " | " + fusee.getLanceur().getNom() + " | " +
               mission.getNom() + " | " +
               (succes ? "SUCCÈS" : "ÉCHEC: " + raison) +
               " | Coût: " + coutTotal + "M€";
    }
}