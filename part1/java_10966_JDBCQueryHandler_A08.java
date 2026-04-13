import java.sql.*;

public class java_10966_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_db_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM your_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Print out each column's data
                System.out.println(resultSet.getString("your_column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}