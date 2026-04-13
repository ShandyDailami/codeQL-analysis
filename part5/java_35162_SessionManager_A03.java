import javax.naming.*;
import javax.sql.*;

public class java_35162_SessionManager_A03 {
    private static final String USER_DB = "your_db_username";
    private static final String PASS_DB = "your_db_password";

    public static void main(String[] args) {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/YourDB");

            SessionFactory sf = ds.getSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            // Do some security-sensitive operations here

            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}