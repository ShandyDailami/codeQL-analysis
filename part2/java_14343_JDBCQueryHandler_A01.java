import java.sql.*;

public class java_14343_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "bob"); // Bob is the only user in the database

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String usernameDB = resultSet.getString("username");
                String passwordDB = resultSet.getString("password");

                System.out.println("User Found: " + usernameDB + " " + passwordDB);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}