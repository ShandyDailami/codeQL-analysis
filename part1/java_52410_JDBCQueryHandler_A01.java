import java.sql.*; // Import the necessary classes/packages from standard library and third-party libraries e.g., mysql.*, jdbc driver packages etc..      
       
public class java_52410_JDBCQueryHandler_A01 {   
     public static void main(String[] args)  
      { 
          Connection con = null; // Declare the connection object as a global variable and initialize it to Null.        
           try{                          
              Class.forName("com.mysql.cj.jdbc.Driver");// Load MySQL JDBC driver   
               System.out.println("Loaded Driver succesfully!");  // Display the success message           
                     con = DriverManager.getConnection( "jdbc:mysql://localhost/mydb", "username","password" );   /* Get a Connection to Database */       }     catch (Exception e) {    System.out.println("Failed due exception : ",e);} // Catch the error if any occurred during connection setup 
          
          Statement stmt = con.createStatement();     
             try{                    
               String sql="SELECT * FROM Employee";   /* Define SQL query */      
                ResultSet rs  =stmt.executeQuery(sql);     // Execute the Query and store it in result set   
                  while (rs.next()) {  System.out.println("Accessing data using getString, " + rs.getString("Name")); } /* Access each column value */                     con.close();      } catch (SQLException e)   // Catch any error that may occur during query execution                   
               {}                          finally{System.out.print("\nClosing Connection");  if(con != null){ try { con.close();}catch ( SQLException ex ) {ex.printStackTrace(); }} }                   System.exit(0); // Exit program to end the session        });