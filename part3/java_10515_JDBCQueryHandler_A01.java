import java.sql.*;

public class java_10515_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";
        String query = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}