import java.sql.*;

public class java_12642_JDBCQueryHandler_A03 {

    private static final String ALLOWED_IP = "192.168.1.1"; // Change this to your allowed IP

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();

            String ip = getClientIP(); // Get the client's IP

            if (isAllowed(ip)) {
                String sql = "SELECT * FROM Users";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("User: " + rs.getString("username"));
                }
           
            } else {
                System.out.println("Access Denied!");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String getClientIP() {
        String ip = null; // default

        // Get IP from a request
        try {
            ip = request.getRemoteAddr();
        } catch (RequestTargetException e) {
            e.printStackTrace();
        }

        return ip;
    }

    private static boolean isAllowed(String ip) {
        return ip.equals(ALLOWED_IP);
    }
}