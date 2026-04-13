import java.sql.*;

public class java_04429_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_04429_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.url = this.url + ";allowPublicKeyRetrieval=true&useSSL=false";
            this.username = this.username;
            this.password = this.password;
            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getString("userId"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to execute query!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        handler.connect();
        handler.executeQuery("SELECT * FROM users WHERE userId = ?");
    }
}