import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_01441_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_01441_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming MySQL JDBC driver
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/test", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Result: " + result.getString("field_name"));
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add more methods for insert, delete, update operations as needed
}