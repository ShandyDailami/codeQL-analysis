import java.sql.*;

public class java_30768_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String query = "SELECT password FROM users WHERE username = 'myuser'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String password = resultSet.getString(1);
                // Here you would check the password against a hashed value.
                // This is a very basic example and in a real-world application,
                // you would need to use a more secure method to compare passwords.
                if (password.equals("hashedpassword")) {
                    System.out.println("Authentication successful.");
                } else {
                    System.out.println("Authentication failed.");
                }
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}