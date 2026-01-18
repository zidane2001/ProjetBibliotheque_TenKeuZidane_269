# Scénarios de Test - Système de Gestion de Bibliothèque

## 1. Tests de la classe Livre

### Test 1.1 - Création d'un livre

- **Entrée**: id=1, titre="Le Petit Prince", auteur="Antoine de Saint-Exupéry", categorie="Roman", nombreExemplaires=5
- **Résultat attendu**: Objet Livre créé avec toutes les valeurs correctes
- **Statut**: ✅ Passé

### Test 1.2 - Modification du titre

- **Action**: livre.setTitre("Nouveau Titre")
- **Résultat attendu**: getTitre() retourne "Nouveau Titre"
- **Statut**: ✅ Passé

### Test 1.3 - Affichage des détails

- **Action**: livre.afficherDetails()
- **Résultat attendu**: Affiche "1 | Le Petit Prince | Antoine de Saint-Exupéry | Roman | 5"
- **Statut**: ✅ Passé

---

## 2. Tests de la classe Membre

### Test 2.1 - Création d'un membre

- **Entrée**: id=1, nom="Dupont", prenom="Jean", email="jean.dupont@email.com", adhesionDate=date actuelle
- **Résultat attendu**: Objet Membre créé avec toutes les valeurs correctes
- **Statut**: ✅ Passé

### Test 2.2 - Modification de l'email

- **Action**: membre.setEmail("nouveau@email.com")
- **Résultat attendu**: getEmail() retourne "nouveau@email.com"
- **Statut**: ✅ Passé

### Test 2.3 - Affichage des détails

- **Action**: membre.afficherDetails()
- **Résultat attendu**: Affiche les informations du membre formatées
- **Statut**: ✅ Passé

---

## 3. Tests de la classe Emprunt

### Test 3.1 - Création d'un emprunt

- **Entrée**: idEmprunt=1, membreId=10, livreId=20, dateEmprunt=aujourd'hui, dateRetourPrevue=dans 14 jours, dateRetourEffective=null
- **Résultat attendu**: Objet Emprunt créé avec dateRetourEffective null
- **Statut**: ✅ Passé

### Test 3.2 - Enregistrement du retour

- **Action**: emprunt.setDateRetourEffective(new Date())
- **Résultat attendu**: getDateRetourEffective() retourne la date définie
- **Statut**: ✅ Passé

---

## 4. Tests de l'interface utilisateur (Main)

### Test 4.1 - Menu principal

- **Action**: Lancer l'application
- **Résultat attendu**: Affichage du menu avec 7 options (0-6)
- **Statut**: ✅ Passé

### Test 4.2 - Gestion des entrées invalides (texte au lieu de nombre)

- **Entrée**: "abc" au lieu d'un choix numérique
- **Résultat attendu**: Message "Erreur : Veuillez entrer un nombre entier valide."
- **Statut**: ✅ Passé

### Test 4.3 - Gestion des choix hors limites

- **Entrée**: 99 comme choix de menu
- **Résultat attendu**: Message "Choix invalide ! Veuillez entrer un nombre entre 0 et 6."
- **Statut**: ✅ Passé

### Test 4.4 - Ajout d'un livre avec nombre d'exemplaires négatif

- **Entrée**: -5 pour le nombre d'exemplaires
- **Résultat attendu**: Message "Erreur : Veuillez entrer un nombre positif."
- **Statut**: ✅ Passé

### Test 4.5 - Ajout d'un membre avec email invalide

- **Entrée**: "emailsansarobase" pour l'email
- **Résultat attendu**: Message "Erreur : Veuillez entrer une adresse email valide"
- **Statut**: ✅ Passé

### Test 4.6 - Champ vide

- **Entrée**: Chaîne vide pour le titre d'un livre
- **Résultat attendu**: Message "Erreur : Ce champ ne peut pas etre vide."
- **Statut**: ✅ Passé

---

## 5. Tests de la base de données (DAO)

### Test 5.1 - Connexion à la base de données

- **Action**: DBConnection.getConnection()
- **Résultat attendu**: Connexion établie ou message d'erreur explicite
- **Statut**: ✅ Passé

### Test 5.2 - Ajout d'un livre en base

- **Action**: livreDAO.ajouterLivre(livre)
- **Résultat attendu**: Livre inséré dans la table 'livres'
- **Statut**: ✅ Passé

### Test 5.3 - Liste des livres

- **Action**: livreDAO.listerLivres()
- **Résultat attendu**: Liste de tous les livres de la base
- **Statut**: ✅ Passé

### Test 5.4 - Ajout d'un membre en base

- **Action**: membreDAO.ajouterMembre(membre)
- **Résultat attendu**: Membre inséré dans la table 'membres'
- **Statut**: ✅ Passé

### Test 5.5 - Ajout d'un emprunt en base

- **Action**: empruntDAO.ajouterEmprunt(emprunt)
- **Résultat attendu**: Emprunt inséré dans la table 'emprunts'
- **Statut**: ✅ Passé

---

## 6. Tests de robustesse

### Test 6.1 - Driver PostgreSQL manquant

- **Condition**: Exécution sans le JAR PostgreSQL dans le classpath
- **Résultat attendu**: Message "Erreur : Driver PostgreSQL non trouvé"
- **Statut**: ✅ Passé

### Test 6.2 - Base de données inaccessible

- **Condition**: Serveur Neon indisponible
- **Résultat attendu**: Message d'erreur de connexion avec détails
- **Statut**: ✅ Passé

---

## Résumé des tests

| Catégorie  | Tests passés | Tests échoués | Total  |
| ---------- | ------------ | ------------- | ------ |
| Livre      | 3            | 0             | 3      |
| Membre     | 3            | 0             | 3      |
| Emprunt    | 2            | 0             | 2      |
| Interface  | 6            | 0             | 6      |
| DAO        | 5            | 0             | 5      |
| Robustesse | 2            | 0             | 2      |
| **Total**  | **21**       | **0**         | **21** |

---

## Instructions pour exécuter les tests JUnit

1. Télécharger JUnit 5 (junit-jupiter-api-5.x.x.jar et junit-jupiter-engine-5.x.x.jar)
2. Placer les JARs dans le dossier `src/libs/`
3. Compiler les tests:
   ```bash
   javac -cp ".:libs/*" resources/*Test.java
   ```
4. Exécuter les tests:
   ```bash
   java -cp ".:libs/*" org.junit.platform.console.ConsoleLauncher --scan-classpath
   ```
