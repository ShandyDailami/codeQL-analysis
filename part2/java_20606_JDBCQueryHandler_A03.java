import java.sql.*;

public class java_20606_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_20606_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = "";
        try {
            // 1. Driver load
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create connection
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process the ResultSet
            while (rs.next()) {
                result += rs.getString("column_name") + "\n";
            }

            // 6. Cleanup
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db_name", "username", "password");
        System.out.println(handler.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'"));
    }
}