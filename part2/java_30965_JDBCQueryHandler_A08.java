import java.sql.*;

public class java_30965_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            String query = "SELECT * FROM Employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 1); // Assuming that the id is an integer.

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Found employee with id: " + resultSet.getInt("id"));
            } else {
                System.out.println("No employee found with the given id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}