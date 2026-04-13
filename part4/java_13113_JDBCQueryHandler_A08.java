import java.sql.*;

public class java_13113_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_13113_JDBCQueryHandler_A08() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Security-sensitive operation: Accessing data without proper authorization
                String column1 = resultSet.getString("column1");
                // Additional security-sensitive operation: Reading data that is not intended
                String column2 = resultSet.getString("column2");
                System.out.println("Column 1: " + column1);
                System.out.println("Column 2: " + column2);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing query");
            e.printStackTrace();
        }
    }
}