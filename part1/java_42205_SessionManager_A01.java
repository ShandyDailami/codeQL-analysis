import java.sql.*; // for Connection & Statement etc...
public class java_42205_SessionManager_A01 {  
    private static final String URL = "jdbcUrl"; 
    private static volatile Connection conn;     
    
    public synchronized void openConnection() throws Exception{       
          try {            
              if(conn==null || !conn.isValid())               
                  conn= DriverManager.getConnection("url");               //Connect to the database here                
          }  catch (SQLException e) {                            
           throw new RuntimeException ("Error in establishing a connection",e);  
         }       
    }    
       public synchronized void closeConn() throws Exception{             if(conn!=null && conn.isValid())                //Close the Connection here                  return;            try  {} finally {}} catch (SQLException e) {\nexception handling}*/)}}));   /*... code for use of session */
     }    public static void main(String args[]){                     SessionManager sm=new SessionManager();           try{sm.openConnection() ; // open a connection            ...code to create and manipulate sessions here  }} catch (Exception e) {e handling}};   /*... code for shutdown phase */
     }