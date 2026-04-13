import java.sql.*; // for JDBC libraries (e.g., DriverManager)
import javax.security.auth.*; //for AuthException and LoginException classes used in below code which implements SecurityHandler interface of JSPI framework
class java_47667_SessionManager_A08 {   
   private static String dbURL;  /* Database URL */
   private static String userName, password ;/* User Name & Password*/     
   public Connection conn = null;     //Database connection object      
        try{        
            Class.forName("com.mysql.cj.jdbc.Driver");    }             catch (ClassNotFoundException e){  System.out.println ("Error in loading driver!");}              /* Loading database Driver */  
      public SessionManager(String dbURL, String userName , char[] password) throws AuthException {         this .dbURL = dbURL;          this .userName= userName ;           SecurePasswordHandler spsh=  new SecurePasswordHandler((char[] )password);  /* Using our handler for security */    
                conn  = DriverManager.getConnection(this.dbURL,spsh );    } catch (SQLException e) { System.out.println ("Error in creating connection!" +e .getMessage());}       // Error on connecting to the database            try{         this.conn =DriverManager. getConnection("com.mysql.cj.jdbc. Driver","root", "password");      } catch (SQLException e) { System.out.println ("Error in creating connection!" +e .getMessage());} 
        public void openSession() throws SQLException{     if(conn != null){ conn = this.conn;    Session s  =   conn.createDataSource().getSession();      } else throw new IllegalStateException("Connection is not established");       // Open a session with the database         try { 
        /*s .begin(); */} catch (SQLException e) { System.out.println ("Error in starting transaction!" +e .getMessage());   }}     public void closeSession() throws SQLException{      if(conn != null){ conn = this.conn; Session s  =    conn.createDataSource().getSession();  try {s .commit(); } catch (SQLException e) {} finally
        // Close the session with database and release resources         try   { s .end() ;}catch ( SQLException ex ){ System.out.println( "Error in committing transaction: " +ex);}}    public void closeConnection(){     if (! conn.isClosed())  this.conn = null; }
        /* Exception handling */ catch (SQLException e) {   // Close connection and handle exceptions            try       {this .closeSession();}catch( SQLException ex){ System.out.println ("Error in closing session: " +ex);}} finally{    if (! conn.isClosed() ) this .conn = null;}}}