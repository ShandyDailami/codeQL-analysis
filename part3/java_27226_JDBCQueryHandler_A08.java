import java.sql.*;

public class java_27226_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String procedureName = "procedure_name";
            PreparedStatement preparedStatement = connection.prepareCall("{call " + procedureName + "(?, ?, ?)}");

            // Set input parameters
            preparedStatement.setInt(1, 123);
            preparedStatement.setString(2, "test");
            preparedStatement.setDouble(3, 45.67);

            // Execute the stored procedure
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Result: " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}