import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41316_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;

    public java_41316_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        //Step 1: Register JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Step 2: Establish a connection
        conn = DriverManager.getConnection(dbURL, user, password);
        //Step 3: Create a statement
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        //Step 4: Execute a query
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        //Step 6: Close connection
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) {
        try {
            //Step 5: Create a connection
            JDBCQueryHandler jdbc = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
            //Step 7: Use the connection
            ResultSet rs = jdbc.executeQuery("SELECT * FROM employees");
            //Step 8: Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
            //Step 9: Close the connection
            jdbc.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}