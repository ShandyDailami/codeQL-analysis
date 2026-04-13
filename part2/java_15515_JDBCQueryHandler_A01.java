import java.sql.*;

public class java_15515_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM SensitiveData"; // replace with your actual query
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String sensitiveData = resultSet.getString("SensitiveData");
                System.out.println("Found sensitive data: " + sensitiveData);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}