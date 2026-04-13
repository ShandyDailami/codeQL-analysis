import java.sql.*;

public class java_37652_JDBCQueryHandler_A03 {
    private Connection conn = null;

    public java_37652_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            // Assuming the database is MySQL and we're connecting to a local database
            String dbURL = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "root";
            String password = "password";
            new JDBCQueryHandler(dbURL, user, password);

            // Let's say we want to retrieve a user's details
            String query = "SELECT * FROM users WHERE id = ?";
            ResultSet rs = executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Email: " + email);
            }

            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}