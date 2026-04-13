import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22968_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            statement = connection.prepareStatement("SELECT * FROM mytable WHERE mycolumn = ?");

            // Step 4: Set a parameter
            statement.setString(1, "myvalue");

            // Step 5: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Process the result
            while (resultSet.next()) {
                String columnValue = resultSet.getString("mycolumn");
                System.out.println("Column Value: " + columnValue);
            }

            // Step 7: Close the connection
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}