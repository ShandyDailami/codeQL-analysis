import java.sql.*;

public class java_21777_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Example: Attempt to update a row in the table, with a condition that the row must already exist
            String query = "UPDATE Employee SET Salary = Salary + Salary * 0.10 WHERE EmployeeID = 1";
            statement.executeUpdate(query);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}