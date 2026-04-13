import java.sql.*;

public class java_33994_JDBCQueryHandler_A03 {

    // This is the JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    // The username and password for the database
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // This is the JDBC connection
    private Connection conn = null;

    public void connectToDatabase() {
        try {
            // Load the driver
            Class.forName(DRIVER);
            // Open a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Process the ResultSet
            while (rs.next()) {
                // Here, we're assuming that the query is going to return a single value
                String result = rs.getString(1);
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}