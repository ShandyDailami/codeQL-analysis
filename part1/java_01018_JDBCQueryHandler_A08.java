import java.sql.*;

public class java_01018_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_01018_JDBCQueryHandler_A08(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
        this.stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return this.stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        this.stmt.close();
        this.conn.close();
    }

    public static void main(String[] args) {
        try {
            // Replace with your actual database credentials
            String dbURL = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "password";

            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, user, password);

            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStmt = handler.conn.prepareStatement(query);
            preparedStmt.setInt(1, 123);
            ResultSet resultSet = handler.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}