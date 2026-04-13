import java.sql.*;   // To get access the database methods and classes   
public class java_52371_JDBCQueryHandler_A07 {      // Class name should be in CamelCase for JAVA conventions        
     public static void main(String[] args)        // Main method, which is always present      
     {                                           // This serves as the entry point to our application         
            String url = "jdbc:mysql://localhost/test";   // The URL of your database    '//' indicates a path-relative string.  e.g., jdbc\sqlserver, mysql...etc     
            
         try (Connection con=DriverManager.getConnection(url,"username","password"))       {     // Try and finally block are used to ensure that the connection is closed in case of any exceptions       
                Statement stmt = null;    // A statement represents an individual SQL command   e.g., INSERT, UPDATE...etc 
             try{                     
                    String sql="SELECT * FROM Users WHERE Username LIKE 'John' AND Password != 1234";     /* Your secure query here */       
                     stmt = con.createStatement();      // Create a statement using the connection    e.g., SELECT, UPDATE...etc      
                      ResultSet rs=stmt.executeQuery(sql);   /// Execute and get result set from SQL command  - This operation is blocking     /* You may want to put this in try/catch block */         
                     // Process your results here: loop through the data using a while-loop      e.g., While (rs.next()) {...}        System.out .println( rs..getString("name") );       } finally {}  /* This is always executed, even if an exception occurred in try or catch */
             // End of block to hold the database resources so that they can be released properly     e.g., closing connections (con variable) and Statements/ResultSets(stmt & rs variables )   close() method will release these resource  only when required by JVM       }catch(){}}// Catch statements are used for exception handling       
             // Your code goes here: the program should run smoothly if no exceptions occur. This is where you could write your full logic or do more complex processing, depending on what exactly A07_AuthFailure was to be done by this application   }  /* End of main method */      catch (SQLException ex){ System . out . println (" Error in executing the SQL query " +ex);}
     }} //End Class declaration and try/catch block for handling resources. This is necessary as Java handles exceptions pretty well but if not, we need to explicitly handle it at our own risk   }  /* End of class */    catch (Exception ex) { System . out . println ("Error: " +ex);}} // Catch all the other unforeseen exception