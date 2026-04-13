import java.sql.*;

public class java_24114_JDBCQueryHandler_A07 {

    // Secure database details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // SQL queries
    private static final String SELECT_QUERY = "SELECT * FROM Employees";
    private static final String INSERT_QUERY = "INSERT INTO Employees(id, name, salary) VALUES(?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Employees SET salary = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM Employees WHERE id = ?";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement insertStatement = null;
        PreparedStatement updateStatement = null;
        PreparedStatement deleteStatement = null;

        try {
            // 1. Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(false);

            // 2. Prepare statements
            selectStatement = connection.prepareStatement(SELECT_QUERY);
            insertStatement = connection.prepareStatement(INSERT_QUERY);
            updateStatement = connection.prepareStatement(UPDATE_QUERY);
            deleteStatement = connection.prepareStatement(DELETE_QUERY);

            // 3. Execute statements
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double salary = resultSet.getDouble(3);

                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

            insertStatement.setInt(1, 4);
            insertStatement.setString(2, "Test User");
            insertStatement.setDouble(3, 5000.0);
            insertStatement.executeUpdate();

            updateStatement.setDouble(1, 5500.0);
            updateStatement.setInt(2, 4);
            updateStatement.executeUpdate();

            deleteStatement.setInt(1, 3);
            deleteStatement.executeUpdate();

            // 4. Close connections
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}