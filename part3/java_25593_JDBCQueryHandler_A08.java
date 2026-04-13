import java.sql.*;

public class java_25593_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // A method to execute a SELECT query
    public static ResultSet executeSelectQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // A method to execute an INSERT, UPDATE, DELETE query
    public static int executeUpdateQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        String selectQuery = "SELECT * FROM Users";
        ResultSet rs = executeSelectQuery(selectQuery);
        if (rs != null) {
            try {
                while (rs.next()) {
                    System.out.println(rs.getString("username"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String insertQuery = "INSERT INTO Users (username, password) VALUES ('test', 'test')";
        executeUpdateQuery(insertQuery);

        String updateQuery = "UPDATE Users SET password = 'newpassword' WHERE username = 'test'";
        executeUpdateQuery(updateQuery);

        String deleteQuery = "DELETE FROM Users WHERE username = 'test'";
        executeUpdateQuery(deleteQuery);
    }
}