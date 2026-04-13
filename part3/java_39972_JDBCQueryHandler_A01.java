import java.sql.*;

public class java_39972_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            // Query to select all data from a specific table.
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                // Access Control (A01_BrokenAccessControl): Check if the user trying to access this data is the same as the one in the table.
                if ("user".equals(resultSet.getString("username"))) {
                    System.out.println("Access Denied!");
                    return;
                }

                // Access Control (A01_BrokenAccessControl): Check if the user trying to update this data is the same as the one in the table.
                if ("admin".equals(resultSet.getString("username")) && "update".equals(resultSet.getString("action"))) {
                    System.out.println("Access Denied!");
                    return;
                }

                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Action: " + resultSet.getString("action"));
           .
            .
            // More code...

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}