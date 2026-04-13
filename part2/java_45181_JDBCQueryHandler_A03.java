import java.sql.*;   // Import necessary classes for JDBC (Java Database Connectivity) operations, such as Connection, Statement etc.   
                   
public class java_45181_JDBCQueryHandler_A03 {    
    public static void main(String[] args){       
         String url = "jdbc:mysql://localhost/test";   // your database URL here; replace with actual one when you have it         
         Connection conn=null;      // JDBC connection object to connect our application and MySQL server 
                                      // Here, we assume that a specific driver is already present in classpath.    
        Statement stmt = null ;    // statement objects are used for running SQL commands on the database  
                                    
         try {                    // Begin block of code which contains all operations related to JDBC          
            conn=DriverManager.getConnection(url,"user","password");  // Establish a connection with MySQL Server using URL and user credentials       
             System.out.println("Connected Successfully!");  
              stmt = conn.createStatement();    // Create statement object for executing SQL commands on database          
         } catch (SQLException e) {       // Catch block to handle any exceptions that might occur while connecting and running query         
             System.out.println("Failed in Connection: " +e);     
         };       
                  if(stmt != null){    // Try/catch blocks are used here for safety, it can't be possible without them          
                      String sql ="SELECT * FROM employees";   // Your SQL query         
                       try { 
                           ResultSet rs =  stmt.executeQuery(sql);     // Execute the Query and get result set        
                            while (rs.next())      // Loop through each row of data returned by our SELECT statement          
                               System.out.println("First Name: " + rs.getString("first_name"));   // Fetching first name from MySQL database         
                       } catch(SQLException e){  // Catch block for exceptions related to SQL operations     
                           System.out.println ("Failed in executing query"+e);      
                        };       
                  };         stmt.close();     conn.close();   try{if (conn != null) conn.close();}catch(SQLException e){System.out.println("Connection Closed!" + e ); }      System.exit(0);  // Close all resources once done with them         
    };       protected void finalize(){};     public static boolean isNumeric (String str){return str != null && str.matches ("^[0-9]*$");}   private String sanitiseInputsForSQL(final String s) {  if(!isNumeric((new StringBuilder()).append(s).toString())){ return "'" + new StringBuilder().append(s).toString()+ "'"; } else throw new IllegalArgumentException("Not a valid string: '" + s + '\'');};     };