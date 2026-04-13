import java.sql.*;

public class java_06225_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql = "INVALID SQL"; // This is a valid SQL statement, but we are inserting an invalid one into the database
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Result: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}