import java.sql.*;

public class java_35258_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_35258_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // process the resultSet
                System.out.println("Result: " + resultSet.getString("fieldName"));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.executeQuery("SELECT * FROM tableName");
    }
}