import java.sql.*;

public class java_34070_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_34070_JDBCQueryHandler_A08(String dbURL, String userName, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, userName, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            // Print column names
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + ": ");
                    System.out.println(rs.getObject(i));
                }
                System.out.println("------------------------");
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Failed to execute query");
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Failed to execute update");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection");
            e.printStackTrace();
        }
    }
}