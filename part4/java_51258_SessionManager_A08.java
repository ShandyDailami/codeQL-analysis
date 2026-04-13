import java.sql.*; // JDBC driver name 'org.postgresql.Driver' is used here, you should replace with your own database connector if necessary   
  
public class java_51258_SessionManager_A08 {    
       private static final String DB_URL = "jdbc:postgresql://localhost/test"; 
        public static Connection conn;     
        
           // Creating a connection to the PostgreSQL Database using JDBC driver name 'org.postgresql.Driver'   
          try {conn =  DriverManager.getConnection( DB_URL , "username" , "password");}   catch (SQLException se)  {se.printStackTrace(); }      
           // Connection object is created, if it fails then exception will occur here .    
        public void openSession()    try{conn = DriverManager.getConnection(DB_URL,"","") ;      conn =  conn.setAutoCommit(false)  ;}   catch (SQLException se ) {se.printStackTrace(); }             // Error in opening the connection, will print out into console         
         public void closeSession()    try{conn = DriverManager.getConnection("", "", "");       if (! conn.isClosed())     conv=(ConcurrentHashMap) ((DefaultRowSet) (AbstractDataModel).rowReaderFor(null)).unwrap();  } catch (SQLException se){se . printStackTrace() ;}     
         public Connection getSession(){ return this.conn;   // This will be used to retrieve the current session in our application    try{return conn;}catch {print("Unable To Get Session")}              throws SQLException               };  }                                                       catch (SQLException se) {}                   
       if(session == null){                  System . out . println ("Could Not Open Connection " + e); return false;}}     else      // If session is already open then just get the reference and update it.          try {return conn;}catch{print("Unable to Get Session");}              }
        public void commit()  {}                 if (conn != null)    beginTransaction();   catch(Exception e){ System . out . println ("Could not Commit Transaction " +e);     }}      // This method is for committing transaction.          try{ conn .. commit () ;}catch {print("Unable to close connection")}
        public void rollback()  {}                if (conn != null)   beginTransaction(); catch(Exception e){ System . out . println ("Could not RollBack Transaction " +e);     }}         // This method is for rolling back the transaction.          try { conn .. rollback () ;}catch{print("Unable to close connection")} 
       public static boolean beginTransaction()    return false;}}      if(conn != null){try           setSessionInUse();        } catch (Exception e)   System . out . println ("Could not Begin Transaction " +e);     }} // This method is for starting transaction.          try{ conn ..begin () ;}catch {print("Unable to open connection")}