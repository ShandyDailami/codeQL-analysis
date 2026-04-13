import java.sql.*;

public class java_30315_JDBCQueryHandler_A03 {

    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO Employee (Name, Salary) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameters
            statement.setString(1, "John Doe");
            statement.setDouble(2, 50000.00);

            // Execute the query
            statement.executeUpdate();

            // Close the connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}