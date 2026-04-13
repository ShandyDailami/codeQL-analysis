import java.sql.*;

public class java_15977_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_15977_JDBCQueryHandler_A03() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
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
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("Name: " + name + ", Age: " + age);
        }

        queryHandler.executeUpdate("UPDATE users SET age = 30 WHERE name = 'John'");
    }
}