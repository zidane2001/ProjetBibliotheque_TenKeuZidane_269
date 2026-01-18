public class Livre {
    private final int id;
    private String titre;
    private String auteur;
    private String categorie;
    private int nombreExemplaires;

    public Livre(int id, String titre, String auteur, String categorie, int nombreExemplaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.nombreExemplaires = nombreExemplaires;
    }

    public int getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public int getNombreExemplaires() {
        return this.nombreExemplaires;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }

    public void afficherDetails() {
        System.out.println(this.id + " | " + this.titre + " | " + this.auteur + " | " + this.categorie + " | " + this.nombreExemplaires);
    }
}
