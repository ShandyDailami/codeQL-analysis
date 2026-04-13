import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_07619_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        // Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java driver not found.");
        }

        // Open a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");

            // Define and execute a SQL query
            String query = "SELECT * FROM mytable WHERE mycolumn = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "value"); // Replace 'value' with the value you want to match

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        // Process each row of the result set
                        System.out.println("Row found: " + resultSet.getString("mycolumn"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database or executing query.");
            e.printStackTrace();
        }
    }
}