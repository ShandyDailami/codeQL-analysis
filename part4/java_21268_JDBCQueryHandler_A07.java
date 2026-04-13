import java.sql.*;

public class java_21268_JDBCQueryHandler_A07 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 3: Execute stored procedure
            CallableStatement cs = conn.prepareCall("{call my_stored_procedure(?)}");
            cs.setString(1, "some_parameter");
            cs.execute();

            // Step 4: Handle the result
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                System.out.println("Got result: " + rs.getString("result_column"));
            }

            // Step 5: Close connections
            rs.close();
            cs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}