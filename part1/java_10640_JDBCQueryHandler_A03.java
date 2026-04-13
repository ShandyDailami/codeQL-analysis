import java.sql.*;

public class java_10640_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE name = ?";
        String name = "John";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userName = resultSet.getString("name");
                System.out.println("User name: " + userName);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}