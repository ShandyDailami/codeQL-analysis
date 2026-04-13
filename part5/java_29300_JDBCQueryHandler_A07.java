import java.sql.*;

public class java_29300_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email = '" + args[0] + "'");

            if (resultSet.next()) {
                System.out.println("User found with email: " + resultSet.getString("email"));
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}