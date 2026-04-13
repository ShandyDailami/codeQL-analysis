import java.sql.*;

public class java_25898_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Initialize a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            //Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            //Step 4: Handle the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            //Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}