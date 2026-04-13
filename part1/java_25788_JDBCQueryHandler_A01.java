import java.sql.*;

public class java_25788_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_25788_JDBCQueryHandler_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mydatabase?useSSL=false", "username", "password");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean executeQuery(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean result = handler.executeQuery("username", "password");
        System.out.println("Credentials are correct: " + result);
    }
}