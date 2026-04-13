import java.sql.*;
public class java_50178_JDBCQueryHandler_A03 {   // Starts with 'Java'.
    public static void main(String[] args) throws SQLException{     // Instructions start from here! (c, d). 
        String url = "jdbc:mysql://localhost/test";                    // This is a sample database URL. Replace it accordingly in your case (!)!  
        String username ="username_here";                           // Enter the user name for mysql server connection you want to establish! (b)   
        String password="password_here";                             // Insert Password here, same as MySQL Server's root pass. Do not share it in public repo or network(a). 
        
      try {  
            Connection con = DriverManager.getConnection(url , username, password);    /// This will get a connection from the database (c)     // Exactly (!), Instructions start here! c . d e f g h i j k l m n o p q r s t u v w x y z
             Statement stmt = con.createStatement();                         // Create statement for query execution 
            String sql="SELECT * FROM table_name";                           /// Select all data from a specific Table (b, d)  
         ResultSet resultset =  stmt.executeQuery(sql);                     // Execute SQL Query and get the results back to us! f h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z
             while (resultset .next()) {                                /// Loop through each row of ResultSet obtained from the SQL query // c, e. g h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z
                 System .out .println (resultset .getString("column_name"));   /// print out the value of a specific column in each row. Replace 'table' and 'password', add or remove columns according to your needs! // b, d e f g h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z
             }  
        con.close();                                                       /// Close the connection once we are done with it (c) // Exactly (!), Instructions start here! c . d e f g h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z
         } catch(SQLException sqlEx){                                          // Catch the exception if there is any (c,d)   e. g h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z
             System .out .println ("Error in executing sql : " +sqlEx);      // Print the error message (c, d e f g h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z
         }  
    }}                                                   /// Exactly (!), Instructions start here! c . d e (g) f g h i j k l m n o p q r s t u v w x y z 10q2r3s4t5v6w7y9z