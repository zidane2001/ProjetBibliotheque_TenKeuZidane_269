import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpruntDAO {
    public EmpruntDAO() {
    }

    public void ajouterEmprunt(Emprunt emprunt) {
        String sql = "INSERT INTO emprunts (membreId, livreId, dateEmprunt, dateRetourPrevue, dateRetourEffective) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emprunt.getMembreId());
            stmt.setInt(2, emprunt.getLivreId());
            stmt.setDate(3, emprunt.getDateEmprunt());
            stmt.setDate(4, emprunt.getDateRetourPrevue());
            stmt.setDate(5, emprunt.getDateRetourEffective());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Emprunt> listerEmprunts() {
        List<Emprunt> emprunts = new ArrayList<>();
        String sql = "SELECT * FROM emprunts";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Emprunt emprunt = new Emprunt(
                    rs.getInt("idEmprunt"),
                    rs.getInt("membreId"),
                    rs.getInt("livreId"),
                    rs.getDate("dateEmprunt"),
                    rs.getDate("dateRetourPrevue"),
                    rs.getDate("dateRetourEffective")
                );
                emprunts.add(emprunt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprunts;
    }
}
