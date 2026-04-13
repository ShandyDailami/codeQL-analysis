import java.sql.*; // Import necessary classes here: ResultSet, Statement & Connection  
class java_46768_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{       
           String url = "jdbc:mysql://localhost/test";         
           String username="root", password="password1234567890@!";  // Provide your own credentials.   
           
         Connection conn =  DriverManager.getConnection(url,username , password);  
        System.out.println("Connected to database");         
           String SQLQuery = "SELECT * FROM users WHERE id=?" ;    
             Statement stmtOut  =conn.createStatement();    // Create a statement object for handling the execution of our queries           
              ResultSet rs =  stmtOut .executeQuery(SQLQuery);  // Execute query and return result set         
           while (rs.next()) {   // Iterate over each row returned by executeQuery call     }       System.out.println("User Details: " + rs.getString('username'));    conn.close();        };            
      }}`;  The comment is removed for clarity in the response as per your request and it'll be replaced with a message at runtime when executing this code, based on if there are any errors or not (in which case you will print an error). Also remember to replace 'root', password1234567890@! where necessary.