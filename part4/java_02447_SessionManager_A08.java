import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.RowSetProvider;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.Session;
import javax.sql.RowSet;

public class java_02447_SessionManager_A08 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    private static SessionManager instance;
    
    private DataSource dataSource;
    
    private java_02447_SessionManager_A08() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/MyDB");
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    public Session getSession() {
        try {
            return dataSource.getSession();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void close(Session session) {
        if(session != null) {
            session.close();
        }
    }
    
    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Session session = sm.getSession();
        
        // Start integrity check
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        
        try {
            RowSet rowSet = RowSetProvider.newInstance().getRowSet();
            rowSet.addRows(session, list);
        } catch (SQLException e) {
            // Handle integrity failure here
            e.printStackTrace();
        }
        
        sm.close(session);
    }
}