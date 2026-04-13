import java.sql.*;

public class java_00229_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM table_name"; // replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // process the resultSet
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}