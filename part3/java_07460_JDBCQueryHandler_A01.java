import java.sql.*;

public class java_07460_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public java_07460_JDBCQueryHandler_A01() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        // Example of querying data
        String query = "SELECT * FROM Users";
        ResultSet resultSet = queryHandler.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }

        // Example of updating data
        String updateQuery = "UPDATE Users SET email = 'newemail@example.com' WHERE name = 'John'";
        int rowsUpdated = queryHandler.executeUpdate(updateQuery);
        System.out.println("Rows updated: " + rowsUpdated);

        connection.close();
    }
}