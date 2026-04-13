import java.sql.*;

public class java_02513_JDBCQueryHandler_A07 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username = ?";
        String username = "test";

        try {
            // Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Prepare the statement
            stmt = conn.prepareStatement(query);

            // Set the parameter
            stmt.setString(1, username);

            // Execute the query
            rs = stmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");

                System.out.println("User Found: " + usernameDB + ", " + passwordDB);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the resources
            closeConnection();
        }
    }

    private static void closeConnection() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}