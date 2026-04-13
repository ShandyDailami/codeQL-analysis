import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class java_27376_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your MySQL username:");
        String username = scanner.next();

        System.out.println("Enter your MySQL password:");
        String password = scanner.next();

        System.out.println("Enter your MySQL database:");
        String db = scanner.next();

        System.out.println("Enter your SQL query:");
        String query = scanner.next();

        scanner.close();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + db, username, password);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            System.out.println("An error occurred while connecting to the database or executing the query.");
            e.printStackTrace();
        }
    }
}