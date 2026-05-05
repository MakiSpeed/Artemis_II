import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistence {

    private static final String FICHIER = "historique.csv";

    public void sauvegarder(List<Lancement> historique) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHIER))) {
            for (Lancement l : historique) {
                writer.write(
                    l.getDate() + ";" +
                    l.getFusee().getLanceur().getNom() + ";" +
                    l.getFusee().getCapsule().getNom() + ";" +
                    l.getMission().getNom() + ";" +
                    l.isSucces() + ";" +
                    l.getRaison() + ";" +
                    l.getCoutTotal()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde : " + e.getMessage());
        }
    }

    public List<String> charger() {
        List<String> lignes = new ArrayList<>();
        File fichier = new File(FICHIER);

        // Si le fichier n'existe pas encore
        if (!fichier.exists()) {
            System.out.println("Aucun historique trouvé.");
            return lignes;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                lignes.add(ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur chargement : " + e.getMessage());
        }
        return lignes;
    }

    public void afficherHistorique() {
        List<String> lignes = charger();
        if (lignes.isEmpty()) {
            System.out.println("Aucun lancement dans l'historique.");
            return;
        }
        System.out.println("\n=== HISTORIQUE DES LANCEMENTS ===");
        for (String ligne : lignes) {
            String[] parts = ligne.split(";");
            System.out.println(
                "Date: " + parts[0] +
                " | Lanceur: " + parts[1] +
                " | Capsule: " + parts[2] +
                " | Mission: " + parts[3] +
                " | Résultat: " + (parts[4].equals("true") ? "SUCCÈS" : "ÉCHEC") +
                " | Raison: " + parts[5] +
                " | Coût: " + parts[6] + "M€"
            );
        }
    }
}