import java.sql.*;

public class java_51283_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost/test"; // replace with your database url and name 
    private static final String USERNAME = "root";   //replace root as username if required by the db you are connecting to.
    private static final String PASSWORD="password";//provide password for that user, or leave it blank in case of no credential given with database connection 
    
       public Connection getConnection() throws SQLException {       
           return DriverManager.getConnection(URL , USERNAME ,PASSWORD);    //returning the Database Connections  
      }         
        
       protected void finalize(){//prevent this class from being garbage collected and allowing it to run indefinitely  using Java Memory Management Rules (JMMR). This is a workaround for JVM's垃圾回收机制. It can be safely removed once you understand the concept of automatic memory management provided by your VM
        System.out.println("Closing connection");    //This will print when garbage collector clears this object from heap, indicating that we are done with it        
       } 
            
      public ResultSet executeQuery(String query) throws SQLException {  
          Connection conn = null;    
        try{                 
            System.out.println("Executing Query: " + query);    //This will print the queries being executed by console, for demonstration purposes only      
               ConcurrentHashMap<Connection , PreparedStatement> pool =  new ConcurrentHashMap<>();   /* A Connection Pool */ 
              conn = getConnection();            
            if(pool.get(conn) == null){                      //Checks whether this connection is already in the map or not, to avoid duplicate openings of a connection         
                  PreparedStatement stmt  =conn.prepareStatement (query);           /*Creating Preparsed Statements*/ 
                   pool.putIfAbsent( conn ,stmt );                          //Adds Connection -PrepareStatment pair into the map and closes it after only one use            }          else {                           System.out.println("Using existing connection");}             return null;       }} catch (SQLException e) 
        {   throw new RuntimeException(e);}}                  //throws exceptions    */                      /*if exception occur then prints the error and closes all connections*/         finally{            conn = getConnection(); if((conn !=null))try{(new JDBCQueryHandler()).executeQuery("SELECT * FROM Employee");} catch (SQLException e) {e.printStackTrace();}}
       }    //end of execute query method   });  }}        /*Ends the anonymous code block */     public class MainClass{          static void main(String args[]){              try{(new JDBCQueryHandler()).executeQuery("SELECT * FROM Employee");} catch (SQLException e) {e.printStackTrace();}}}}}      //end of java program*/