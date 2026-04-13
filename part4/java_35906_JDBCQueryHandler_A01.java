import java.sql.*;

public class java_35906_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:placeholder://username:password";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            executeQuery(connection);
            executeInsert(connection);
            executeUpdate(connection);
            executeDelete(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("Name: " + name + ", Age: " + age);
        }
        resultSet.close();
        statement.close();
    }

    private static void executeInsert(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
        preparedStatement.setString(1, "John");
        preparedStatement.setInt(2, 30);
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Number of rows affected: " + affectedRows);
        preparedStatement.close();
    }

    private static void executeUpdate(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET age = ? WHERE name = ?");
        preparedStatement.setInt(1, 31);
        preparedStatement.setString(2, "John");
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Number of rows affected: " + affectedRows);
        preparedStatement.close();
    }

    private static void executeDelete(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        int affectedRows = statement.executeUpdate("DELETE FROM users WHERE name = ?");
        System.out.println("Number of rows affected: " + affectedRows);
        statement.close();
    }
}