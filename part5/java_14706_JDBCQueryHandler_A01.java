import java.sql.*;

public class java_14706_JDBCQueryHandler_A01 {

    // The database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // JDBC driver name and database URL
    private static final String Driver = "com.mysql.cj.jdbc.Driver";

    // Constructor to load the driver
    public java_14706_JDBCQueryHandler_A01() {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public void executeQuery(String query) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Print out the result
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a PreparedStatement
    public void executePreparedStatement(String query, String param) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, param);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}