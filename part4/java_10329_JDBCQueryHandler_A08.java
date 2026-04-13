import java.sql.*;

public class java_10329_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_10329_JDBCQueryHandler_A08(String dbURL, String user, String pass) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, pass);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            // Change the URL, username, and password to match your MySQL setup
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

            ResultSet rs = handler.executeQuery("SELECT * FROM my_table");
            while (rs.next()) {
                System.out.println(rs.getString("my_column"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}