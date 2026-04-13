import java.sql.*;

public class java_31383_JDBCQueryHandler_A01 {
    //Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    //Method to handle queries
    public static void handleQuery(String query) {
        try {
            //Step 1: Establish connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //Step 2: Prepare statement
            Statement statement = connection.createStatement();

            //Step 3: Execute query
            ResultSet resultSet = statement.executeQuery(query);

            //Step 4: Handle result set
            while (resultSet.next()) {
                System.out.println("Query result: " + resultSet.getString("column_name"));
            }

            //Step 5: Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Use your own query here
        handleQuery("SELECT * FROM table_name");
    }
}