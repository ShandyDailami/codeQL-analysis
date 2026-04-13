import java.sql.*;

public class java_30886_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            createTable();
            insertData();
            selectData();
            deleteData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() throws SQLException {
        String query = "CREATE TABLE Users (" +
                "id INT PRIMARY KEY, " +
                "username VARCHAR(50), " +
                "password VARCHAR(50), " +
                "email VARCHAR(100))";
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    private static void insertData() throws SQLException {
        String query = "INSERT INTO Users (id, username, password, email) VALUES (1, 'user1', 'password1', 'user1@email.com')";
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    private static void selectData() throws SQLException {
        String query = "SELECT * FROM Users WHERE id = 1";
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void deleteData() throws SQLException {
        String query = "DELETE FROM Users WHERE id = 1";
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }
}