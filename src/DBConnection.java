import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://ep-dawn-wildflower-ah7o1047-pooler.c-3.us-east-1.aws.neon.tech/neondb?sslmode=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_HT3iyLz4OrDI";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver PostgreSQL charge avec succes");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Driver PostgreSQL non trouve");
            System.err.println("Veuillez ajouter postgresql-{version}.jar au classpath");
            e.printStackTrace();
        }
    }

    public DBConnection() {
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("");
            }
        } catch (SQLException e) {
            System.err.println("Erreur de connexion a la base de donnees :");
            System.err.println("URL: " + URL);
            System.err.println("Utilisateur: " + USER);
            System.err.println("Message: " + e.getMessage());
            if (e.getMessage().contains("password authentication failed")) {
                System.err.println("-> Verifiez le mot de passe dans le dashboard Neon");
                System.err.println("-> Le mot de passe peut avoir expire, regenerez-le");
            } else if (e.getMessage().contains("database") && e.getMessage().contains("does not exist")) {
                System.err.println("-> La base 'neondb' n'existe pas sur ce serveur");
                System.err.println("-> Verifiez le nom de la base dans le dashboard Neon");
            } else if (e.getMessage().contains("connection refused") || e.getMessage().contains("timeout")) {
                System.err.println("-> Probleme reseau ou serveur Neon indisponible");
                System.err.println("-> Verifiez votre connexion internet");
                System.err.println("-> Verifiez le statut du projet dans le dashboard Neon");
            } else if (e.getMessage().contains("SSL")) {
                System.err.println("-> Probleme SSL, verifiez que votre JVM supporte TLS 1.2+");
            }
        }

        return conn;
    }
}
