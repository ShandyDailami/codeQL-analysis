import java.sql.*;

public class java_29091_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // Start a transaction
            conn.setAutoCommit(false);

            String query1 = "INSERT INTO Users (username, password, email) VALUES ('user1', 'password1', 'user1@example.com')";
            String query2 = "INSERT INTO Users (username, password, email) VALUES ('user2', 'password2', 'user2@example.com')";
            String query3 = "INSERT INTO Users (username, password, email) VALUES ('user3', 'password3', 'user3@example.com')";

            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);

            // Commit the transaction
            conn.commit();
            conn.setAutoCommit(true);

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}