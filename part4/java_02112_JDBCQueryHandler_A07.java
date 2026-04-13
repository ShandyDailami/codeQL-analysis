import java.sql.*;

public class java_02112_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_02112_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String update) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");

        ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }

        queryHandler.executeUpdate("UPDATE users SET password = 'newpassword' WHERE username = 'user'");
    }
}