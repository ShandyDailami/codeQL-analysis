import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29176_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Set up the database connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Query 1: Select all data from table1
            String query1 = "SELECT * FROM table1";
            ResultSet resultSet1 = statement.executeQuery(query1);

            while (resultSet1.next()) {
                // Process the data from each row
                int id = resultSet1.getInt("id");
                String name = resultSet1.getString("name");
                // More code here...

                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Query 2: Select all data from table2
            String query2 = "SELECT * FROM table2";
            ResultSet resultSet2 = statement.executeQuery(query2);

            while (resultSet2.next()) {
                // Process the data from each row
                int id = resultSet2.getInt("id");
                String address = resultSet2.getString("address");
                // More code here...

                System.out.println("ID: " + id + ", Address: " + address);
            }

            // Cleanup
            resultSet1.close();
            resultSet2.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}