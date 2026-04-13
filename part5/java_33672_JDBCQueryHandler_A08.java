import java.sql.*;
import java.util.Properties;

public class java_33672_JDBCQueryHandler_A08 {
    // Step 1: Establish a Connection
    private Connection conn = null;

    public java_33672_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/database.properties"));
            String driver = props.getProperty("database.driver");
            String connectionString = props.getProperty("database.url");
            String user = props.getProperty("database.user");
            String password = props.getProperty("database.password");

            Class.forName(driver);
            conn = DriverManager.getConnection(connectionString, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Step 2: Execute a Query
    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Step 3: Process the Result Set
                System.out.println("Found " + rs.getRow() + " rows");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM Users");
    }
}