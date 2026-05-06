import java.util.ArrayList;
import java.util.List;

public class Fusee {
    private final Lanceur lanceur;
    private final Capsule capsule;
    private final List<Booster> boosters;

    // Constructeur sans boosters
    public Fusee(Lanceur lanceur, Capsule capsule) {
        this.lanceur = lanceur;
        this.capsule = capsule;
        this.boosters = new ArrayList<>();
    }

    // Constructeur avec boosters (surcharge)
    public Fusee(Lanceur lanceur, Capsule capsule, List<Booster> boosters) {
        this.lanceur = lanceur;
        this.capsule = capsule;
        this.boosters = boosters;
    }

    // Ajouter un booster (surcharge)
    public void ajouterBooster(Booster booster) {
        boosters.add(booster);
    }

    public void ajouterBooster(Booster booster, int quantite) {
        for (int i = 0; i < quantite; i++) {
            boosters.add(booster);
        }
    }

    public double calculerMasseTotale() {
    double masse = capsule.getMasse();
    for (Booster b : boosters) {
        masse += b.getMasse();
    }
    return masse;
}

    public double calculerCoutTotal() {
        double cout = lanceur.getPrix() + capsule.getPrix();
        for (Booster b : boosters) {
            cout += b.getPrix();
        }
        return cout;
    }

    public Lanceur getLanceur() { return lanceur; }
    public Capsule getCapsule() { return capsule; }
    public List<Booster> getBoosters() { return boosters; }

    @Override
    public String toString() {
        return "Fusée: " + lanceur.getNom() + " | Capsule: " + capsule.getNom() +
               " | Boosters: " + boosters.size() + " | Coût: " + calculerCoutTotal() + "M€";
    }
}