import java.sql.*;

public class java_26063_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

            // Step 4: Process the result set
            while (resultSet.next()) {
                // Get the values from the result set
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");

                // Process the data (this is just a placeholder, you would replace this with your actual processing code)
                System.out.println("Column1: " + column1 + ", Column2: " + column2);
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}