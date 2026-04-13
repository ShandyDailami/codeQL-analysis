import java.sql.*;
public class java_42525_SessionManager_A08 {  
    private static int MAX_POOL = 10; // Maximum number for object pool (could also set to unlimited)    
    protected List<Connection> freeConnections = new ArrayList<>();     
      
    public synchronized Connection getSession() throws SQLException{ 
        if(freeConnections.isEmpty()) {  
            while(!isDbUsable())){} // wait until DB becomes usable again (e.g., after a full load)    
             }         
           return freeConnections.remove(0);   
       }        
      public synchronized void releaseSession(Connection cxst){ 
        if (!freeConnections.contains(cxst)){   // Session wasn't in our pool to begin with, so it must be ours    
          try { throw new SQLException("Releasing connection that is not usable"); }       catch (SQLException e) {}      freeConnections.add(0, cxst);}  else    freeConnections.remove(cxst)};   // Session was our turn to be returned    
          try { throw new SQLException("Releasing connection that is not usable"); } catch (SQLException e) {} ;            return;}        private boolean isDbUsable(){/* add code here if needed */return true};  };      });}`   // We don't want to use this method, it seems like a test only.