import java.sql.*;

public class java_00859_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_00859_JDBCQueryHandler_A01(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
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

    public void executeUpdate(String updateQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");

        ResultSet resultSet = handler.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        handler.executeUpdate("UPDATE users SET password = 'newPassword' WHERE name = 'admin'");
    }
}