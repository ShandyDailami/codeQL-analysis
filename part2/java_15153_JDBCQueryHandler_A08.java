import java.sql.*;

public class java_15153_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "SELECT * FROM my_table WHERE column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "some_value");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Process the result
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}