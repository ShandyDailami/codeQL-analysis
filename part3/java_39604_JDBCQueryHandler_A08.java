import java.sql.*;

public class java_39604_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_39604_JDBCQueryHandler_A08(String dbURL, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

class SecurityTest {
    public static void main(String[] args) {
        try {
            // Replace with your actual values
            String dbURL = "jdbc:mysql://localhost:3306/test";
            String userName = "username";
            String password = "password";

            JDBCQueryHandler queryHandler = new JDBCQueryHandler(dbURL, userName, password);

            // Sample SQL query
            String query = "SELECT * FROM Users WHERE Id = " + 1;

            ResultSet resultSet = queryHandler.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("User: " + resultSet.getString("Username"));
            }

            queryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}