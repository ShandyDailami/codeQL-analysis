import java.sql.*;

public class java_34223_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // 1. Create a new table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS TestTable (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            statement.executeUpdate(createTableQuery);

            // 2. Insert data into the table
            String insertQuery = "INSERT INTO TestTable (id, name, age) VALUES (1, 'John Doe', 25), (2, 'Jane Doe', 22)";
            statement.executeUpdate(insertQuery);

            // 3. Select data from the table
            String selectQuery = "SELECT * FROM TestTable";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // 4. Update data in the table
            String updateQuery = "UPDATE TestTable SET age = 26 WHERE id = 1";
            statement.executeUpdate(updateQuery);

            // 5. Delete data from the table
            String deleteQuery = "DELETE FROM TestTable WHERE id = 2";
            statement.executeUpdate(deleteQuery);

            // 6. Drop the table
            String dropTableQuery = "DROP TABLE TestTable";
            statement.executeUpdate(dropTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}