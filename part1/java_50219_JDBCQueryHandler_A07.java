import java.sql.*;
public class java_50219_JDBCQueryHandler_A07 {
     public static void main(String[] args) {        
          try{            
              // Step 1: Establish the connection to database              
              String url = "jdbc:mysql://localhost/testdb";           
              Properties props  = new Properties();               
                             
              Connection conn =  DriverManager.getConnection(url, "user", "password");                            
             /*DriverManager is a utility class that provides methods for initializing the JDBC driver and obtaining connections to databases */  
                  
               // Step 2: Execute SQL query           
                String sql ="SELECT * FROM MyTable";          
              Statement stmt  = conn.createStatement();        
                          /* create a statement object that can execute queries on an established connection*/    
                            
             ResultSet rs =  stmt .executeQuery(sql);          //Step 3: Execute SQL query and get result set    */     
                  while (rs.next()) {                       /// Step4 : Process the retrieved data   using next() method of Resset object to retrieve each field in a row into variables*/      
                    System.out.println("Name:" + rs.getString(1));  //printing Name column from database    
                  }            /*closes while loop */          
                          close methods are called by the JDBC API under-the-hood to ensure all resources (like PreparedStatements, ResultSet objects) get released properly and in a timely manner.   It is generally not necessary as long at you're sure that your code will finish with these lines of closing operations 
                   conn.close();                           //closes the connection when done          */     } catch(SQLException se){}           try { if (stmt != null) stmt.close();}catch      (SQLException se){ /*it is always good practice to close Statement as well in case there are any problems*/   
             }}  //finally ensures that the resource will be closed whether an exception occurs or not   using 'try-with resources' statement we can manage finally block and ensure closing of a Resource, this feature provided by Java8 onwards.       catch(SQLException se){se.printStackTrace();}*/