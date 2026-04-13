import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18773_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Create table
            String createTableSQL = "CREATE TABLE Customers\n" +
                    "(\n" +
                    "  id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "  name VARCHAR(50),\n" +
                    "  address VARCHAR(100)\n" +
                    ")";
            statement.executeUpdate(createTableSQL);

            // Insert data
            String insertSQL = "INSERT INTO Customers (name, address) VALUES ('John', 'Street 1')";
            statement.executeUpdate(insertSQL);

            // Select all data
            String selectAllSQL = "SELECT * FROM Customers";
            ResultSet rs = statement.executeQuery(selectAllSQL);

            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println("name: " + name + ", address: " + address);
            }

            // Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}