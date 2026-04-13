import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19142_SessionManager_A03 {

    public static void main(String[] args) {
        // Load database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Begin a transaction
            connection.setAutoCommit(false);

            // Obtain session from the connection
            Session session = connection.beginSession();

            // Security-sensitive operation related to Injection
            try {
                User user = session.get(User.class, "a03_injection");
                System.out.println("User: " + user.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Commit the transaction
            session.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class User {
        private String name;

        public java_19142_SessionManager_A03(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}