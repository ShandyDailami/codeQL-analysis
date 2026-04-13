import java.sql.*;

public class java_00499_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // This is a potentially dangerous operation
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'baddata'");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("password"));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}