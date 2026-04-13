import java.sql.*;

public class java_40999_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                String password = resultSet.getString("password");
                if (password.startsWith("P")) {
                    String newPassword = "NewPassword"; // change this to the new password
                    statement.executeUpdate("UPDATE employees SET password = '" + newPassword + "' WHERE password = '" + password + "'");
                    System.out.println("Password updated for user: " + resultSet.getString("name"));
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}