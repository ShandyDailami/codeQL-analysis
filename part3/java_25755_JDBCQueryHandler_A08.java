import java.sql.*;

public class java_25755_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Establish Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established!");

            //Step 2: Prepare Statement
            String query = "SELECT * FROM table_name"; //Replace 'table_name' with your table name
            Statement statement = connection.createStatement();

            //Step 3: Execute Query
            ResultSet resultSet = statement.executeQuery(query);

            //Step 4: Process Result
            while (resultSet.next()) {
                //Assuming column1, column2, column3 are your columns in the table
                System.out.println("column1: " + resultSet.getString("column1"));
                System.out.println("column2: " + resultSet.getString("column2"));
                System.out.println("column3: " + resultSet.getString("column3"));
            }

            //Step 5: Close Connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}