#  ARTEMIS II — Simulateur de lancement spatial

Projet Java B1 — Simulateur de lancement de fusée inspiré du programme Artemis de la NASA.

---

##  Description

Application Java en console permettant de :
- Configurer une fusée (lanceur, capsule, boosters)
- Choisir une mission parmi 5 destinations
- Simuler le lancement et obtenir un résultat (succès / échec + raison)
- Calculer le coût total de la mission
- Sauvegarder et afficher l'historique des lancements

---

##  Compilation et exécution

### Prérequis
- Java JDK 17 ou supérieur
- Windows (CMD)

### Compiler
```bash
dir /s /b *.java > sources.txt
javac -d out @sources.txt
```

### Exécuter
```bash
java -cp out Main
```

---

##  Architecture POO

### Hiérarchies (héritage)

```
Lanceur (abstraite)
├── SaturneV
├── Ariane5
├── Falcon9
└── SLS

Capsule (abstraite)
├── Orion
├── CrewDragon
├── Apollo
└── CargoDragon

Mission (abstraite)
├── OrbiteMission
├── ISSMission
├── LuneMission
├── MarsMission
└── CrioLifeEuropa  ← mission personnelle
```

### Composition
```
Fusee
├── Lanceur   (un lanceur)
├── Capsule   (une capsule)
└── Booster[] (liste de boosters)
```

### Autres classes
| Classe | Rôle |
|---|---|
| `Booster` | Propulseur d'appoint, classe simple |
| `Lancement` | Résultat archivé d'une simulation |
| `Simulateur` | Orchestrateur — singleton |
| `Persistence` | Lecture/écriture historique CSV |
| `CarburantInsuffisantException` | Exception métier personnalisée |

---

##  Concepts POO utilisés

| Concept | Où dans le code |
|---|---|
| **Héritage** | `SaturneV extends Lanceur`, `Orion extends Capsule`, etc. |
| **Classe abstraite** | `Lanceur`, `Capsule`, `Mission` |
| **Polymorphisme** | `List<Lanceur>`, `List<Mission>` dans `Simulateur` |
| **Composition** | `Fusee` contient un `Lanceur`, une `Capsule`, des `Booster` |
| **Encapsulation** | Attributs `private` + getters dans toutes les classes |
| **Override** | `calculerPousseeMax()`, `calculerCarburantNecessaire()`, `toString()` |
| **Overload** | `ajouterBooster(Booster)` et `ajouterBooster(Booster, int)` dans `Fusee` |
| **Exception custom** | `CarburantInsuffisantException` levée dans `Simulateur` |
| **Singleton** | `Simulateur.getInstance()` — une seule instance garantie |
| **Collections** | `ArrayList<Lanceur>`, `ArrayList<Mission>`, etc. |
| **Persistance fichier** | `Persistence.java` — lecture/écriture CSV sans librairie externe |

---

##  Données de référence

### Lanceurs

| Lanceur | Habité | Boosters max | Carburant max (t) | Charge utile (t) | Prix (M€) |
|---|---|---|---|---|---|
| Saturne V | Oui | 0 | 2 700 | 140 | 1 500 |
| Ariane 5 | Non | 2 | 700 | 20 | 180 |
| Falcon 9 | Oui | 0 | 500 | 22 | 60 |
| SLS | Oui | 2 | 2 600 | 130 | 2 000 |

### Capsules

| Capsule | Habitée | Occupants max | Masse (t) | Prix (M€) |
|---|---|---|---|---|
| Orion | Oui | 4 | 10.4 | 300 |
| Crew Dragon | Oui | 7 | 12.0 | 150 |
| Apollo | Oui | 3 | 5.6 | 200 |
| Cargo Dragon | Non | 0 | 9.5 | 100 |

### Boosters

| Booster | Poussée (kN) | Masse (t) | Prix (M€) |
|---|---|---|---|
| EAP (Ariane) | 6 470 | 270 | 30 |
| SRB (Shuttle) | 12 500 | 590 | 55 |
| BE-3 | 490 | 25 | 12 |

### Missions

| Mission | Habitée | Distance (km) | Coefficient carburant |
|---|---|---|---|
| Orbite terrestre | Non | 400 | 1.0 |
| ISS | Oui | 400 | 1.2 |
| Lune | Oui | 400 000 | 0.005 |
| Mars | Oui | 225 000 000 | 0.000015 |
| CryoLife Europa  | Non | 628 000 000 | 0.000008 |

---

##  Mission personnelle — CryoLife Europa

**Objectif** : Rechercher de la vie sous la glace d'Europe, lune de Jupiter.

Europe est recouverte de glace. En dessous se trouve probablement un océan d'eau liquide, donc peut-être de la vie microbienne.

**Déroulement** :
1. Une fusée part de la Terre
2. Une sonde atterrit sur Europe
3. Un robot perce la glace
4. Un mini robot analyse l'eau souterraine

**Caractéristiques** :
- Distance : ~628 000 000 km
- Non habitée (sonde + robot uniquement)
- Durée : ~730 jours
- Inspirée de la mission Europa Clipper (NASA)

---

##  Logique métier

### Coût total
```
coût total = prix fusée + (carburant nécessaire × 1 200 €/t)
```

### Carburant nécessaire
```
carburant = (masse totale × distance × coefficient) / 1000
```

### Conditions d'échec
| Condition | Message |
|---|---|
| Trop de boosters | "Trop de boosters" |
| Masse > charge utile max | "Surcharge dépassée" |
| Carburant nécessaire > capacité | "Carburant insuffisant" |
| Mission habitée + capsule cargo | "Capsule incompatible avec une mission habitée" |
| Aléa < 5% | "Anomalie technique imprévue" |

---

##  Déclaration IA

Ce projet a été développé avec l'assistance de Claude (Anthropic) pour :
- La correction d'erreurs de syntaxe Java
- La structure des classes et hiérarchies
- Le débogage de la logique métier

Tout le code a été relu, compris et intégré par l'étudiante.

---

##  Auteur

Marie-Catalina Grenot — B1 — 2025-2026
Toulouse Ynov Campus