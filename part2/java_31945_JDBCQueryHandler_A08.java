import java.sql.*;

public class java_31945_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String sql = "SELECT * FROM Employees WHERE IntegrityFailure = 'true'";
            resultSet = statement.executeQuery(sql);

            // 4. Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");

                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}