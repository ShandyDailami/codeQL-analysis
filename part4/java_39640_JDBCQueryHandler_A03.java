import java.sql.*;

public class java_39640_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM mytable WHERE mycondition";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String column1 = result.getString("column1");
                int column2 = result.getInt("column2");
                // Process the data as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}