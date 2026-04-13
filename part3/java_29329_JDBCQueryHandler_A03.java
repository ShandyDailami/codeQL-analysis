import java.sql.*;

public class java_29329_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM your_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // Process column1 here

                // More code here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}