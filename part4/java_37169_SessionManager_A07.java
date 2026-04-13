import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class java_37169_SessionManager_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Initialize JNDI Context
            Context ctx = new InitialContext();

            // Step 2: Look up the DataSource in the JNDI Context
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");

            // Step 3: Use the DataSource to obtain a connection
            Connection conn = ds.getConnection();

            // Step 4: Use the connection for your session-related operations
            // Here, we're just checking if the connection was successful
            if (conn != null) {
                System.out.println("Connection successful");
            } else {
                System.out.println("Connection failed");
            }

            // Step 5: Clean up the connection
            conn.close();

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}