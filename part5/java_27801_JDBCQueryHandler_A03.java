import java.sql.*;

public class java_27801_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");

            // 2. Create a statement
            Statement statement = connection.createStatement();
            System.out.println("Statement created!");

            // 3. Execute a SQL query
            String sql = "CREATE TABLE Student (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INT," +
                    "city VARCHAR(50))";
            statement.executeUpdate(sql);
            System.out.println("Table created!");

            // 4. Insert data into the table
            sql = "INSERT INTO Student VALUES (1, 'John', 20, 'New York')";
            statement.executeUpdate(sql);
            System.out.println("Data inserted!");

            // 5. Close the connection
            connection.close();
            System.out.println("Connection closed!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}