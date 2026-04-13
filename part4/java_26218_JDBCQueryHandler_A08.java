import java.sql.*;

public class java_26218_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_driver_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            String sql = "SELECT * FROM your_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String password = resultSet.getString("password");
                // Do something with the password (e.g., check it)
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}