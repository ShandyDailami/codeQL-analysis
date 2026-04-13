import java.sql.*;

public class java_33252_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL query
            String query = "SELECT * FROM EMPLOYEE WHERE AGE = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 4: Set the parameter value
            preparedStatement.setInt(1, 30);

            // Step 5: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 6: Process the result
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("ID"));
                System.out.println("Employee Name: " + resultSet.getString("NAME"));
                System.out.println("Employee Age: " + resultSet.getInt("AGE"));
            }

            // Step 7: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}