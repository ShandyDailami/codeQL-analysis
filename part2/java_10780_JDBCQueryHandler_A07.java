import java.sql.*;

public class java_10780_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "some_value"); // replace "some_value" with actual value

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String columnValue = resultSet.getString("my_column");
                // do something with columnValue
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}