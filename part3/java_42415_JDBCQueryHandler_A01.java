import java.sql.*; // Import necessary classes from the standard library package  

public class java_42415_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{        
        Connection conn = null;                
            
        try {                         
            String url="jdbc:mysql://localhost/test";                           // Set URL, username and password as needed  
                                                                                   
            System.out.println("Connecting to database");      
                        
                        /* Create a connection */ 
            conn = DriverManager.getConnection(url,"username","password");                  
                            
                            if (conn == null) {                                     // If the Connection object is not created, print an error message and end            
                System.out.println("Failed to make connection!");                  return;   }  else{     
            System.out.println("\nConnection Successful! ");    }}                 catch(SQLException e){          /* Handle any errors */                            
                            finally {                                                if (conn != null) conn.close();           // Close the Connection at the end of all operations                try                   }}}}}}                  Finally statement to ensure clean up is done