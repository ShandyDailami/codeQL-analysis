import java.sql.*;

public class java_37372_JDBCQueryHandler_A07 {
    private Connection connection;

    public void connectToDatabase(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
            } else {
                System.out.println("Connection to the database is not established. Please connect first.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }

        return resultSet;
    }

    public void executeUpdate(String query) {
        PreparedStatement preparedStatement = null;

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
            } else {
                System.out.println("Connection to the database is not established. Please connect first.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}