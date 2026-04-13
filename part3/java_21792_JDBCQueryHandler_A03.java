import java.sql.*;

public class java_21792_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");
                if (resultSet.next()) {
                    System.out.println("Found user with username: " + resultSet.getString("username"));
                } else {
                    System.out.println("No user found with the provided credentials");
                }
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
            return DriverManager.getConnection(URL, USER, PASS); // Connect to the database
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
            return null;
        }
    }
}