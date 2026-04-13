import java.sql.*;

public class java_38134_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // replace with your database url
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("User authentication failed");
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}