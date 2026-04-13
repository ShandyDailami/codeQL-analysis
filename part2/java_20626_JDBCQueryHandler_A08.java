import java.sql.*;

public class java_20626_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection con;

    public static void main(String[] args) {
        // Step 1: Establish a Connection
        establishConnection();

        // Step 2: Execute a Query
        String query = "SELECT * FROM mytable";
        executeQuery(query);

        // Step 3: Close the Connection
        closeConnection();
    }

    private static void establishConnection() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}