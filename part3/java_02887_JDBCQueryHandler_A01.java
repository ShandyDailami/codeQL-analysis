import java.sql.*;

public class java_02887_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String selectQuery = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, 123); // replace 123 with the id of the user

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}