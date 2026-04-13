import java.sql.*;

public class java_11536_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/db_example";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established!");

            // Step 2: Prepare Statement
            Statement statement = connection.createStatement();
            System.out.println("Statement prepared!");

            // Step 3: Execute SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM table_example");
            System.out.println("Query executed!");

            // Step 4: Process ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}