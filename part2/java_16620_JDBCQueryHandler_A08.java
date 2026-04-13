import java.sql.*;

public class java_16620_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_16620_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "root", "password");
        ResultSet result = handler.executeQuery("SELECT * FROM users");
        while (result.next()) {
            System.out.println(result.getString("username"));
        }
        handler.executeUpdate("UPDATE users SET password='newpassword' WHERE username='admin'");
    }
}