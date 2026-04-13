public class java_13127_JDBCQueryHandler_A07 {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME = 'test'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
           
                //Here's the security-sensitive part:
                //We're just checking if the password matches a hard-coded value.
                //This is a very simple example and doesn't actually use any encryption.
                if (password.equals("password")) {
                    System.out.println("Successfully authenticated!");
                } else {
                    System.out.println("Authentication failed!");
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}