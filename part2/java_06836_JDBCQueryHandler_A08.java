import java.sql.*;

public class java_06836_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();

            // CREATE
            String createTableSQL = "CREATE TABLE Employees ("
                    + "ID INT PRIMARY KEY,"
                    + "Name VARCHAR(50),"
                    + "Salary DOUBLE)";
            statement.executeUpdate(createTableSQL);

            String insertSQL = "INSERT INTO Employees (ID, Name, Salary) VALUES (1, 'John', 70000.00)";
            statement.executeUpdate(insertSQL);

            // READ
            String selectSQL = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("ID"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
            }

            // UPDATE
            String updateSQL = "UPDATE Employees SET Salary = 80000.00 WHERE ID = 1";
            statement.executeUpdate(updateSQL);

            // DELETE
            String deleteSQL = "DELETE FROM Employees WHERE ID = 1";
            statement.executeUpdate(deleteSQL);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}