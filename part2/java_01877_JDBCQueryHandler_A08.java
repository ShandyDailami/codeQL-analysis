import java.sql.*;

public class java_01877_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String passwordFromDB = rs.getString("password");
                if (passwordFromDB.equals(args[1])) {
                    System.out.println("Access Granted");
                } else {
                    System.out.println("Access Denied");
                }
            } else {
                System.out.println("User Not Found");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}