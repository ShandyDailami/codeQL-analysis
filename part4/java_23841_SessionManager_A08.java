import java.sql.*;

public class java_23841_SessionManager_A08 {
    private Connection conn = null;
    private Statement stmt = null;

    //Establishes a connection to the database
    public Connection openConnection(String dbURL, String userName, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            conn = null;
        }
        return conn;
    }

    //Performs a SQL statement on the database
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Query execution failed");
            e.printStackTrace();
        }
        return rs;
    }

    //Closes the connection to the database
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Database connection close failed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.openConnection("jdbc:mysql://localhost/testdb", "root", "password");
        sm.executeQuery("SELECT * FROM Users");
        sm.closeConnection();
    }
}