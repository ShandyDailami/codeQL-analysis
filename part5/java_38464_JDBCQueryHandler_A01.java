import java.sql.*;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_38464_JDBCQueryHandler_A01 {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    // Method to return a hashed version of the input string
    public String getHashedPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
            return null;
        }
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    // Method to validate the input against the hashed password
    public boolean validatePassword(String input, String hashedPassword) {
        return getHashedPassword(input).equals(hashedPassword);
    }

    public void dbOperation() {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "root";
        String password = "root";

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT password FROM users WHERE username='test'");

            if(rs.next()){
                String hashedPassword = rs.getString(1);
                System.out.println("Hashed Password: " + hashedPassword);

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your password to verify: ");
                String enteredPassword = sc.next();

                if(validatePassword(enteredPassword, hashedPassword)){
                    System.out.println("Access granted!");
                }else{
                    System.out.println("Access denied!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null)
                    conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.dbOperation();
    }
}