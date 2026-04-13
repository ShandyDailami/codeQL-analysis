import java.sql.*;

public class java_14634_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM your_table_name WHERE your_condition";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String column1 = result.getString("column1");
                // process column1, if necessary
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}