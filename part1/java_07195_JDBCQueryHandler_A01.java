import java.sql.*;

public class java_07195_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users WHERE role = 'admin'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String userName = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("User Name: " + userName);
                System.out.println("Role: " + role);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}