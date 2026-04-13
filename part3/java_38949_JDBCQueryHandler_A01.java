import java.sql.*;

public class java_38949_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 101); // Setting a hard-coded value for demonstration purposes
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
                System.out.println("User Email: " + resultSet.getString("email"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}