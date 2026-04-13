import java.sql.*;

public class java_04677_JDBCQueryHandler_A07 {
    // The JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    // Constructor
    public java_04677_JDBCQueryHandler_A07() {
        // Initialize DB connection
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to validate user
    public boolean validateUser(String username, String password) {
        // Use JDBC to retrieve data from DB
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("password").equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}