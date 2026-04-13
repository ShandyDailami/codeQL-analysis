import java.sql.*;   // Java Database Connectivity API(JDBC) 

public class java_45129_JDBCQueryHandler_A07 {   
     private static final String DB_URL = "jdbc:mysql://localhost/test";//Replace with your own URL and db name, it might differ from the one used in example.
       public static Connection conn;   // Database connection variable to hold reference of connections opened by clients 
       
    /* Method establishes a database connectivity */    
      private void establishConnection() {        
            try{            
                if(conn == null || !conn.isValid())                    
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","password");   //Replace 'password' with your own MySQL root password  and replace test db name accordingly    
           } catch (SQLException e) {     
                System.out.println(e);   
            }}        
        public static void main(String[] args){         
             new JdbcQueryHandler().establishConnection();   // establish connection with database,  it's always good practice to call method in the constructor of your class          
       }    
      /* Method that executes an SQL query */   
         private ResultSet executeSQL(String sql) {         
             Statement stmt = null;              try{                   //prepare statement for execution.               if (conn !=null )                conn.close();                    System.out.println("Closed Connection");} catch (Exception ex){   }                  return  null;}     public void closeConnection(){    /*Method to disconnect from database */     
           if(stmt!=null) try { stmt.close();conn =null;System.out.print ("Disconnected Successfully.");}}       else{ System.err .println("Cannot execute query");}        }   // Method that executes an SQL statement, the method is open for reuse     
    @Override public void finalize() { closeConnection ();  /* When JVM collects object it will call this function to clean up */     try{ if(conn!=null) conn.close();}}            System .out .println ("Exiting Main App"); }} // Closing Connection in the end of program execution