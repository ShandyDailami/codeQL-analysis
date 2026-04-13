import java.sql.*;

public class java_12913_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public java_12913_JDBCQueryHandler_A07() {
        initializeDB();
    }

    private void initializeDB() {
        try {
            // Load JDBC driver
            Class.forName(DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = conn.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // SQL Query Example
    public void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);

            // print the query results
            while (rs.next()) {
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // SQL Update Example
    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler dbHandler = new VanillaJDBCQueryHandler();

        // SQL Query
        String query = "SELECT id, name FROM user";
        dbHandler.executeQuery(query);

        // SQL Update
        String updateQuery = "UPDATE user SET name = 'John' WHERE id = 1";
        dbHandler.executeUpdate(updateQuery);
    }
}