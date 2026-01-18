import java.sql.Date;

public class Emprunt {
    private int idEmprunt;
    private int membreId;
    private int livreId;
    private Date dateEmprunt;
    private Date dateRetourPrevue;
    private Date dateRetourEffective;

    public Emprunt(int idEmprunt, int membreId, int livreId, Date dateEmprunt, Date dateRetourPrevue, Date dateRetourEffective) {
        this.idEmprunt = idEmprunt;
        this.membreId = membreId;
        this.livreId = livreId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourEffective = dateRetourEffective;
    }

    public int getIdEmprunt() {
        return this.idEmprunt;
    }

    public int getMembreId() {
        return this.membreId;
    }

    public int getLivreId() {
        return this.livreId;
    }

    public Date getDateEmprunt() {
        return this.dateEmprunt;
    }

    public Date getDateRetourPrevue() {
        return this.dateRetourPrevue;
    }

    public Date getDateRetourEffective() {
        return this.dateRetourEffective;
    }

    public void setDateRetourEffective(Date dateRetourEffective) {
        this.dateRetourEffective = dateRetourEffective;
    }

    public void afficherDetails() {
        System.out.println(this.idEmprunt + " | Membre: " + this.membreId + " | Livre: " + this.livreId + " | Emprunt: " + this.dateEmprunt + " | Retour prevu: " + this.dateRetourPrevue + " | Retour effectif: " + this.dateRetourEffective);
    }
}
