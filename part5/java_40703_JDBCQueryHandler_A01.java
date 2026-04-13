import java.sql.*;

public class java_40703_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connect();
            executeQuery();
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery() throws SQLException {
        String query = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    private static void executeUpdate() throws SQLException {
        String query = "UPDATE users SET name = 'John' WHERE age = 30";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}