import java.sql.*;

public class java_28033_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE AuthFailure > 5");

            while (resultSet.next()) {
                String userId = resultSet.getString("userId");
                String userName = resultSet.getString("userName");
                System.out.println("User ID: " + userId);
                System.out.println("User Name: " + userName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}