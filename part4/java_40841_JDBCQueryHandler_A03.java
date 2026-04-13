import java.sql.*;

public class java_40841_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_40841_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        ResultSet result = handler.executeQuery("SELECT * FROM users");

        while (result.next()) {
            System.out.println(result.getString("username"));
        }

        handler.executeUpdate("UPDATE users SET username = 'newusername' WHERE username = 'oldusername'");
    }
}