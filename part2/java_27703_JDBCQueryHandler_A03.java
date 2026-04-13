import java.sql.*;

public class java_27703_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // This is a placeholder for real password

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            // Example of user's password leakage
            String password = "password123";
            statement.executeUpdate("INSERT INTO users (password) VALUES ('" + password + "')");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + USER + "'");
            while (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                System.out.println("Password in the database: " + dbPassword);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}