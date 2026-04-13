import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeMBeanException;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class java_14781_SessionManager_A07 {
    private Map<String, Session> sessions = new HashMap<>();
    private DataSource dataSource;

    public java_14781_SessionManager_A07() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL("jdbc:mysql://localhost:3306/mydatabase");
        ds.setUser("root");
        ds.setPassword("password");

        this.dataSource = ds;
    }

    public Session getSession(String key) {
        Session session = sessions.get(key);

        if (session == null) {
            try {
                session = dataSource.getConnection().createSession();
                sessions.put(key, session);
            } catch (Exception e) {
                throw new RuntimeMBeanException(e);
            }
        }

        return session;
    }

    public void closeSession(String key) {
        Session session = sessions.get(key);

        if (session != null) {
            session.close();
            sessions.remove(key);
        }
    }
}