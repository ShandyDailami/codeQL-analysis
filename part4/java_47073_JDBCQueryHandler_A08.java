import java.sql.*;   // Import required classes from the 'java' package, such as Connection and Statement   

public class java_47073_JDBCQueryHandler_A08 {    
       static final String url = "jdbc:mysql://localhost/testdb";     
       static final String username ="root1234567890qwertyuiopasdfghjkzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";   // This should be your real user name   
       static final String password= "password_goeshere1234567890qwertyuiopasdfghjkzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";  // This should be your real user's credentials    
        public static void main(String args[]){   
            Connection conn = null;   // Initialize connection to the database     
             try {       /* Try block for Database operations */        
                 System.out.println("Connecting to MySQL...");  // Display a message on console         
                  Class.forName('com.mysql.cj.Driver');    // Load driver class     Driver manager is used here, not the database server     
                   conn = DriverManager.getConnection(url ,username , password );   /* Method getconnection() of connection object returns an instance reference (reference) to connect with specific url and credentials */          System.out.println("Connected");    // Display a message on console         } catch Exception e { println ("Exception: " +e);  - Catch block for Database exceptions    
              finally{             /* Execute any code in the 'finally' section, whether try or catch has been executed */           System.out.println("Closing connection...") ;    // Display a message on console         conn.close();   }          Printing out database operation result using statement and call executeQuery method 
             PreparedStatement pstmt = null;       /* Execute SQL operations such as UPDATE, DELETE or INSERT */        try {     System.out.println("Executing Query");      String query="SELECT * FROM user";   // Create the SELECT sql to be executed           Connection conn1  =conn ;        
             ResultSet rs = null;            /* Execute SQL operations such as UPDATE, DELETE or INSERT */          try{    Class c =Class.forName("com.mysql.cj.Driver");        } catch (Exception ex) {ex.printStackTrace();}     pstmt=conn1 .prepareStatement(query); rs= 
             /* Execute the above prepared statement  and get a result set */           // Calling 'execute' method to execute our SQL query      try{pstmt.executeQuery();    }catch (Exception ex) {ex.printStackTrace()};     while ((rs .next()))          System.out.println("Name: " + rs.getString(1));  
                /* Retrieves data from the ResultSet */           }}  // Closes try and catch block for error handling         Println ("Closing connection..."); conn = null; }   
}