import java.sql.*;

public class java_18747_JDBCQueryHandler_A03 {
    // Security sensitive operations: injection
    private static String url = "jdbc:mysql://localhost:3306/testdb";
    private static String username = "root";
    private static String password = "password";

    // Query operations
    private static String selectQuery = "SELECT * FROM Employees";
    private static String insertQuery = "INSERT INTO Employees (Id, Name, Department, Salary) VALUES (?, ?, ?, ?)";

    public static void main(String[] args) {
        try {
            // Step 1: Initialize Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute Select Query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Step 4: Process ResultSet
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("Id"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Department: " + resultSet.getString("Department"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
            }

            // Step 5: Execute Insert Query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, 1001);
            preparedStatement.setString(2, "John");
            preparedStatement.setString(3, "IT");
            preparedStatement.setDouble(4, 50000.00);
            preparedStatement.executeUpdate();

            // Step 6: Close Connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}