import java.sql.*;

public class java_17273_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:your_database_url";
    private static final String username = "your_username";
    private static final String password = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("your_column_name"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}