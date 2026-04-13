import java.sql.*;

public class java_06837_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            connectDB();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }

    private static void connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "user1");
        preparedStatement.setString(2, "password1");

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("User logged in successfully!");
        } else {
            System.out.println("Invalid username or password");
        }

        connection.close();
    }
}