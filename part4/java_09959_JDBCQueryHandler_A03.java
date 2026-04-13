import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class java_09959_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your_driver://your_host/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your password: ");
        String password = "";
        try {
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            checkPassword(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkPassword(String password) throws SQLException {
        String pattern = ".*password.*";
        if (password.matches(pattern)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}