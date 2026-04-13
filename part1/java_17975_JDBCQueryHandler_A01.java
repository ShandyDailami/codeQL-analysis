import java.sql.*;

public class java_17975_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_17975_JDBCQueryHandler_A01(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception here
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Print result set
                System.out.println(resultSet.getString("columnName"));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception here
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception here
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception here
        }
    }
}