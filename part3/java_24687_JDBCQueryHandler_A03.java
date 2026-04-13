import java.sql.*;

public class java_24687_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_24687_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, user, password);

            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE id = ?");
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}