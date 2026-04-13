import java.sql.*;

public class java_04370_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    private static Connection conn;
    private static Statement stmt;

    // Connect to database
    public java_04370_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch data
    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Update data
    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the connection
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Update password in the database
        String updateQuery = "UPDATE Users SET Password = 'newPassword' WHERE Username = 'user'";
        handler.executeUpdate(updateQuery);

        // Fetch data from the database
        String selectQuery = "SELECT * FROM Users";
        ResultSet resultSet = handler.executeQuery(selectQuery);

        while (resultSet.next()) {
            String username = resultSet.getString("Username");
            String password = resultSet.getString("Password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        handler.closeConnection();
    }
}