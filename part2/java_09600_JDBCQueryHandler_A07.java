import java.sql.*;

public class java_09600_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM myTable WHERE myCondition = 'myConditionValue'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // Process the result set here
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}