import java.sql.*;

public class java_26241_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // Process the result set here
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ...
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}