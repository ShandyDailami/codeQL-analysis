import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03600_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection connection = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // perform some operations here
            // For instance, insert a new record
            String insertQuery = "INSERT INTO test_table (id, name) VALUES (1, 'Test')";
            connection.createStatement().executeUpdate(insertQuery);

            // fetch data
            String selectQuery = "SELECT * FROM test_table";
            ResultSet resultSet = connection.createStatement().executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}