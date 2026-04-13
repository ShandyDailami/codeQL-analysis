import java.sql.*;

public class java_28150_JDBCQueryHandler_A03 {
    //Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    //Query for injection
    private static final String INJECTION_QUERY = "SELECT * FROM Users WHERE username = '" + "testUser' " + "'";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //Step 2: Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(INJECTION_QUERY);

            //Step 3: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Step 4: Process the results
            while(resultSet.next()) {
                String username = resultSet.getString("username");
                //Do something with the username
            }

            //Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}