import java.sql.*;
public class java_43901_JDBCQueryHandler_A08 {   // Define a new Class named 'VanillaJavaJDBCQueryHandler' 
    public static void main(String[] args)     // Start the Main method, where our application begins execution from here           
    {       
          try{           // Begin Try block to handle any exceptions that might occur during database operations.  
                Class.forName("com.mysql.cj.jdbc.Driver");  /* Load MySQL JDBC driver */    
                 String url = "jdbc:mysql://localhost/test?useSSL=false";          // Define URL of the Database we are going to connect with          
                  Connection con  = DriverManager.getConnection(url,"root","password");   // Connecting database, replace root and password as per your mysql server setup     
                 Statement stmt =con .createStatement();     /* Create a statement object */       
                    String sql= "SELECT * FROM users WHERE username='" + args[0]+"' AND password=" +  args[1];  // SQL Query to be executed          
                     ResultSet rs  =stmt.executeQuery(sql);          // Execute the query using executequery method        
                   while (rs .next()) {     /* Fetch and print out each row */    System.out.println("Username: " +   rs.getString("username"));      }      
                  con.close();        stmt.close();          // Close resources to prevent memory leaks  if needed          
              }catch(Exception ex){ex.printStackTrace();}         /* Handle the exception */   
     }// End of Main method  
}/*End Java Program*/