import java.sql.*;

public class java_26477_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // 1. Open a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement object
            Statement statement = connection.createStatement();

            // 3. Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + 123);

            // 4. Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // 5. Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}