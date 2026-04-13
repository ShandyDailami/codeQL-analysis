import java.sql.*;

public class java_32440_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_32440_JDBCQueryHandler_A08(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");
            while (resultSet.next()) {
                // handle the result set
            }
            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}