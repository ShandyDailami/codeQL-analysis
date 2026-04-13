import java.sql.*;

public class java_25429_JDBCQueryHandler_A08 {
    // Driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Open a connection
    private Connection conn = null;
    private Statement stmt = null;

    public java_25429_JDBCQueryHandler_A08() {
        establishConnection();
    }

    // Method to establish a connection
    private void establishConnection() {
        try {
            Class.forName(DB_DRIVER);
            System.out.println("Connecting to database...");
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement object
            this.stmt = conn.createStatement();
            System.out.println("Connected successfully!");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to insert a student
    public int insertStudent(String name, String address) {
        String sql = "INSERT INTO STUDENT (NAME, ADDRESS) VALUES ('" + name + "', '" + address + "')";
        try {
            stmt.executeUpdate(sql);
            return 1;
        } catch (SQLException se) {
            se.printStackTrace();
            return 0;
        }
    }

    // Method to list all students
    public ResultSet listStudents() {
        String sql = "SELECT ID, NAME, ADDRESS FROM STUDENT";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

    // Method to close connection
    public void closeConnection() {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        queryHandler.insertStudent("John Doe", "New York");
        queryHandler.listStudents();
        queryHandler.closeConnection();
    }
}