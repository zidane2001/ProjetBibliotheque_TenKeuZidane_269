import java.sql.Date;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Date adhesionDate;

    public Membre(int id, String nom, String prenom, String email, Date adhesionDate) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adhesionDate = adhesionDate;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getAdhesionDate() {
        return this.adhesionDate;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdhesionDate(Date adhesionDate) {
        this.adhesionDate = adhesionDate;
    }

    public void afficherDetails() {
        System.out.println(this.id + " | " + this.nom + " | " + this.prenom + " | " + this.email + " | " + this.adhesionDate);
    }
}
