import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

public class java_18721_SessionManager_A07 {

    // URL for MySQL
    private final static String DB_URL = "jdbc:mysql://localhost:3306/testDB";
    // Username
    private final static String USER = "root";
    // Password
    private final static String PASS = "root";

    private Connection connection;

    public void start() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = connection.createStatement();
            // Create table SQL
            String sql = "CREATE TABLE Users (" +
                    "id INT PRIMARY KEY," +
                    "username VARCHAR(50)," +
                    "password VARCHAR(50))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void storePassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO Users (username, password) VALUES ('test', '" + hashedPassword + "')";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String password) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'test'");
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return BCrypt.checkpw(password, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void end() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.start();
        sm.storePassword("testPassword");
        System.out.println(sm.authenticate("testPassword"));
        sm.end();
    }
}