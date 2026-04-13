import java.sql.*;

public class java_18454_JDBCQueryHandler_A03 {
    // define database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // prepare a statement
            Statement statement = connection.createStatement();

            // execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // process the result set
            while (resultSet.next()) {
                System.out.println("Found user: " + resultSet.getString("username"));
            }

            // close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}