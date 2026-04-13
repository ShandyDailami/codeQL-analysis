import java.sql.*;

public class java_12560_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String query = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            int id = 1;
            String name = "John Doe";
            double salary = 70000.00;

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, salary);

            statement.executeUpdate();
            System.out.println("Records inserted successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}