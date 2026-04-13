import java.sql.*;

public class java_37191_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_37191_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void authenticate() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming MySQL driver is in classpath
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Successfully authenticated!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failed to authenticate. Error: " + e.getMessage());
       
        }
    }

    public void runQuery(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming MySQL driver is in classpath
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Query result: " + rs.getString(1));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Failed to execute query. Error: " + e.getMessage());
        }
    }
}