import java.sql.*;

public class java_10836_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_10836_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ensure connection is closed even if an exception occurs
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");
    }
}