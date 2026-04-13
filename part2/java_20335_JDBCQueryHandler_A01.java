import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_20335_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Users WHERE id = ?");
             PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Users (id, name) VALUES (?, ?)");
             PreparedStatement updateStatement = connection.prepareStatement("UPDATE Users SET name = ? WHERE id = ?")) {

            // Set parameter and execute select statement
            selectStatement.setInt(1, 123);
            ResultSet rs = selectStatement.executeQuery();

            // Set parameter and execute insert statement
            insertStatement.setInt(1, 123);
            insertStatement.setString(2, "John Doe");
            insertStatement.executeUpdate();

            // Set parameter and execute update statement
            updateStatement.setString(1, "Jane Doe");
            updateStatement.setInt(2, 123);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}