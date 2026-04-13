import java.sql.*;   // Import necessary classes from Standard Libraries of Java 8+ (sun*)   
    
public class java_46447_JDBCQueryHandler_A01 {      // Define the main Class named as "JDBCQueryHandler"      
// Creating a connection object to connect with database        
Connection conn = null;          // Declare Connection variable       
Statement stmt =null ;           //Declaring Statement Variable 
    
public void establishConnections() {    /* Establishing connections */     
try{            
   Class.forName("com.mysql.cj.Driver");        
       conn= DriverManager.getConnection( "jdbc:mysql://localhost/mydb","username", "password" );        //Creating connection with database          
}catch (ClassNotFoundException e) {      /* Handling the exception */ 
   System.out.println("Error Occured while connecting to DB");         
}}    
public void executeQuery(String query){       /* Executed Query inside try-withResource*/    //Create a method named as "executeQueries" with String type argument        
try (Statement stmt = conn.createStatement()) {      /**/       
   ResultSet rs =stmt .executeQuery(query);     *//* Execute the query */          System.out.println("Executing: \n\r" + query );       /* Print Query statement*/         while ((rs.next())){           // Loop through each row of result set           
   String name =  rs.getString ("name");              /**/        }catch (SQLException e){             System.out.println("Error in retrieving data from database: " +e);          }}  /* Catch the exception */      ** End Of Try-Catch block**       // Close statement and connection     stmt .close(); conn.close() ;}}*/