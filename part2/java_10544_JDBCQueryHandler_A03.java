import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class java_10544_JDBCQueryHandler_A03 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Step 1: Load database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // Step 2: Establish database connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Step 3: Prepare and execute SQL query
            System.out.println("Enter SQL query:");
            String query = scanner.nextLine();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                processResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void processResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }
    }
}