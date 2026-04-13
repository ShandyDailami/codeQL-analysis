import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class java_05721_SessionManager_A03 {
    private Connection connection;

    public void connect(String databaseUrl, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(databaseUrl, username, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter database URL:");
        String databaseUrl = scanner.nextLine();
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            sessionManager.connect(databaseUrl, username, password);

            System.out.println("Enter SQL query:");
            String query = scanner.nextLine();

            sessionManager.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}