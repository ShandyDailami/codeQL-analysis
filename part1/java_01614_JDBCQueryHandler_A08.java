import java.sql.*;

public class java_01614_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:placeholder_url";
        String username = "placeholder_username";
        String password = "placeholder_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM table_name";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // do something with the data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}