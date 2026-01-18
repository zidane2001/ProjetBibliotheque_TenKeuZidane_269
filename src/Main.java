import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public Main() {
    }

    private static int lireEntier(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int valeur = Integer.parseInt(sc.nextLine().trim());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre entier valide.");
            }
        }
    }

    private static int lireEntierPositif(String prompt) {
        while (true) {
            int valeur = lireEntier(prompt);
            if (valeur >= 0) {
                return valeur;
            }
            System.out.println("Erreur : Veuillez entrer un nombre positif.");
        }
    }

    private static int lireEntierStrictementPositif(String prompt) {
        while (true) {
            int valeur = lireEntier(prompt);
            if (valeur > 0) {
                return valeur;
            }
            System.out.println("Erreur : Veuillez entrer un nombre superieur a 0.");
        }
    }

    private static String lireChaine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String valeur = sc.nextLine().trim();
            if (!valeur.isEmpty()) {
                return valeur;
            }
            System.out.println("Erreur : Ce champ ne peut pas etre vide.");
        }
    }

    private static String lireEmail(String prompt) {
        while (true) {
            String email = lireChaine(prompt);
            if (email.contains("@") && email.contains(".")) {
                return email;
            }
            System.out.println("Erreur : Veuillez entrer une adresse email valide (ex: exemple@domaine.com).");
        }
    }

    public static void main(String[] args) {
        LivreDAO livreDAO = new LivreDAO();
        MembreDAO membreDAO = new MembreDAO();
        EmpruntDAO empruntDAO = new EmpruntDAO();

        int choix;
        do {
            System.out.println("\n GESTION BIBLIOTHEQUE ");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Lister les livres");
            System.out.println("3. Ajouter un membre");
            System.out.println("4. Lister les membres");
            System.out.println("5. Ajouter un emprunt");
            System.out.println("6. Lister les emprunts");
            System.out.println("0. Quitter");
            
            choix = lireEntier("Votre choix : ");
            
            switch (choix) {
                case 0:
                    System.out.println("Au revoir !");
                    break;
                case 1:
                    ajouterLivre(livreDAO);
                    break;
                case 2:
                    listerLivres(livreDAO);
                    break;
                case 3:
                    ajouterMembre(membreDAO);
                    break;
                case 4:
                    listerMembres(membreDAO);
                    break;
                case 5:
                    ajouterEmprunt(empruntDAO);
                    break;
                case 6:
                    listerEmprunts(empruntDAO);
                    break;
                default:
                    System.out.println("Choix invalide ! Veuillez entrer un nombre entre 0 et 6.");
            }
        } while (choix != 0);

        sc.close();
    }

    private static void ajouterLivre(LivreDAO livreDAO) {
        try {
            String titre = lireChaine("Titre : ");
            String auteur = lireChaine("Auteur : ");
            String categorie = lireChaine("Categorie : ");
            int nb = lireEntierPositif("Nombre d'exemplaires : ");
            
            Livre livre = new Livre(0, titre, auteur, categorie, nb);
            livreDAO.ajouterLivre(livre);
            System.out.println("Livre ajoute avec succes !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }

    private static void listerLivres(LivreDAO livreDAO) {
        try {
            List<Livre> livres = livreDAO.listerLivres();
            if (livres.isEmpty()) {
                System.out.println("Aucun livre dans la bibliotheque.");
            } else {
                System.out.println("\n--- Liste des livres ---");
                for (Livre l : livres) {
                    l.afficherDetails();
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la recuperation des livres : " + e.getMessage());
        }
    }

    private static void ajouterMembre(MembreDAO membreDAO) {
        try {
            String nom = lireChaine("Nom : ");
            String prenom = lireChaine("Prenom : ");
            String email = lireEmail("Email : ");
            Date adhesionDate = new Date(System.currentTimeMillis());
            
            Membre membre = new Membre(0, nom, prenom, email, adhesionDate);
            membreDAO.ajouterMembre(membre);
            System.out.println("Membre ajoute avec succes !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du membre : " + e.getMessage());
        }
    }

    private static void listerMembres(MembreDAO membreDAO) {
        try {
            List<Membre> membres = membreDAO.listerMembres();
            if (membres.isEmpty()) {
                System.out.println("Aucun membre inscrit.");
            } else {
                System.out.println("\n--- Liste des membres ---");
                for (Membre m : membres) {
                    m.afficherDetails();
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la recuperation des membres : " + e.getMessage());
        }
    }

    private static void ajouterEmprunt(EmpruntDAO empruntDAO) {
        try {
            int idMembre = lireEntierStrictementPositif("ID membre : ");
            int idLivre = lireEntierStrictementPositif("ID livre : ");
            int duree = lireEntierStrictementPositif("Duree (jours) : ");
            
            Date dateEmprunt = new Date(System.currentTimeMillis());
            Date dateRetourPrevue = new Date(System.currentTimeMillis() + (long) duree * 24L * 60L * 60L * 1000L);
            
            Emprunt emprunt = new Emprunt(0, idMembre, idLivre, dateEmprunt, dateRetourPrevue, null);
            empruntDAO.ajouterEmprunt(emprunt);
            System.out.println("Emprunt ajoute avec succes !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'emprunt : " + e.getMessage());
        }
    }

    private static void listerEmprunts(EmpruntDAO empruntDAO) {
        try {
            List<Emprunt> emprunts = empruntDAO.listerEmprunts();
            if (emprunts.isEmpty()) {
                System.out.println("Aucun emprunt en cours.");
            } else {
                System.out.println("\n--- Liste des emprunts ---");
                for (Emprunt e : emprunts) {
                    e.afficherDetails();
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la recuperation des emprunts : " + e.getMessage());
        }
    }
}
