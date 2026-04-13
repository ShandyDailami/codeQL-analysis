import java.sql.*;

public class java_34686_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            if (resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                throw new AuthFailureException("Authentication failed!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}