import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23182_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query1 = "CREATE TABLE Users (id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))";
            String query2 = "CREATE TABLE Orders (id INT PRIMARY KEY, user_id INT, order_date DATE, FOREIGN KEY (user_id) REFERENCES Users(id))";
            String query3 = "CREATE TABLE Order_Details (id INT PRIMARY KEY, order_id INT, product_id INT, quantity INT, FOREIGN KEY (order_id) REFERENCES Orders(id))";

            connection.createStatement().execute(query1);
            connection.createStatement().execute(query2);
            connection.createStatement().execute(query3);

            // Insert data
            String insertUser = "INSERT INTO Users (id, name, email) VALUES (1, 'John', 'john@example.com')";
            String insertOrder = "INSERT INTO Orders (id, user_id, order_date) VALUES (1, 1, CURDATE())";
            String insertDetail = "INSERT INTO Order_Details (id, order_id, product_id, quantity) VALUES (1, 1, 1, 2)";

            connection.createStatement().execute(insertUser);
            connection.createStatement().execute(insertOrder);
            connection.createStatement().execute(insertDetail);

            // Update data
            String updateOrder = "UPDATE Orders SET order_date = CURDATE() WHERE id = 1";
            String updateDetail = "UPDATE Order_Details SET quantity = 3 WHERE id = 1";

            connection.createStatement().execute(updateOrder);
            connection.createStatement().execute(updateDetail);

            // Delete data
            String deleteOrder = "DELETE FROM Orders WHERE id = 1";
            String deleteDetail = "DELETE FROM Order_Details WHERE id = 1";

            connection.createStatement().execute(deleteOrder);
            connection.createStatement().execute(deleteDetail);

            System.out.println("Data integrity failed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}