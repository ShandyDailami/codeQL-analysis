import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37873_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_37873_JDBCQueryHandler_A08(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet runSelectQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void runUpdateQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            // In a real application, these values should be securely stored in a configuration file or environment variable
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:yourDB", "username", "password");

            ResultSet rs = handler.runSelectQuery("SELECT * FROM yourTable");

            while (rs.next()) {
                // Process each row of the result set
                System.out.println(rs.getString("columnName"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}