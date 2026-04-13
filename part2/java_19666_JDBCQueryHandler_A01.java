import java.sql.*;

public class java_19666_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SensitiveData");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                handleSensitiveData(id, name, password);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void handleSensitiveData(String id, String name, String password) {
        // Handle sensitive data, such as passwords.
        // This is just a placeholder, replace with actual implementation.
        System.out.println("Handling sensitive data for id: " + id + ", name: " + name + ", password: " + password);
    }
}