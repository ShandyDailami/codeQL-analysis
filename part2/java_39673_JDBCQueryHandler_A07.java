import java.sql.*;

public class java_39673_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        getUserData("john");
    }

    public static void getUserData(String username) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String usernameDB = "username";
        String passwordDB = "password";

        try {
            Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
            String query = "SELECT * FROM users WHERE username = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User: " + user);
                System.out.println("Password: " + password);
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}