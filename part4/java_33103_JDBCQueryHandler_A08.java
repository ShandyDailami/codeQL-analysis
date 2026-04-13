import java.sql.*;

public class java_33103_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_33103_JDBCQueryHandler_A08(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
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
        // In real world scenarios, we might want to handle exceptions in a more structured way
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:yourDatabaseUrl", "yourUsername", "yourPassword");

            ResultSet resultSet = handler.executeQuery("SELECT * FROM yourTable");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("yourColumnName"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error handling database connection: " + e.getMessage());
        }
    }
}