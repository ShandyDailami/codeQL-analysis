import java.sql.*;

public class java_09595_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String passwordInDB = rs.getString("password");
                if (checkPassword(passwordInDB, args[1])) {
                    System.out.println("Successfully authenticated!");
                } else {
                    System.out.println("Authentication failed!");
                }
            } else {
                System.out.println("No user found with provided username!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPassword(String passwordInDB, String enteredPassword) {
        // Simple hashing method. In a real application, you would want to use a more secure method.
        return passwordInDB.equals(enteredPassword);
    }
}