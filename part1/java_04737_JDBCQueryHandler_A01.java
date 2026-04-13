import java.sql.*;

public class java_04737_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Loading Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connection URL and Username
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        // Establishing Connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Prepared Statement
            String query = "SELECT * FROM mytable";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                // Printing Result Set
                while (resultSet.next()) {
                    System.out.println("Result: " + resultSet.getString("mycolumn"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}