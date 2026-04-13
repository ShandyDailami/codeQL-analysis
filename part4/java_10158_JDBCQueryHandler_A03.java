import java.sql.*;

public class java_10158_JDBCQueryHandler_A03 {

    private static final String URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM your_table WHERE condition = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameter
            statement.setString(1, "your_value");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Record fetched!");
                // process the resultSet
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}