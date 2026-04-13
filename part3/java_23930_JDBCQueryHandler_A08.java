import java.sql.*;

public class java_23930_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                executeQuery(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Establishes a connection to the database. Replace with your actual database details.
    private static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:your_database_driver",
                "username",
                "password");
        return conn;
    }

    // Executes a SQL query on the database. Replace with your actual SQL query.
    private static void executeQuery(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

        while (rs.next()) {
            // Prints the first name of each person in the table.
            System.out.println("First Name: " + rs.getString("first_name"));
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}