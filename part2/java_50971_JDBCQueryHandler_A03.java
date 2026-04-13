import java.sql.*;
public class java_50971_JDBCQueryHandler_A03 {    
    public static void main(String[] args)  throws SQLException{        // a method to connect with database          
            String url = "jdbc:mysql://localhost/testdb";              // Database URL, replace it according your db        
            Connection conn= DriverManager.getConnection (url,"user", "password");    // Get connection         
            
            /* Injecting user input into query */                        
           PreparedStatement pstmt =conn.prepareStatement("SELECT * FROM users WHERE id IN (?) AND name LIKE ?");      
                                                     
                  String in_id="1";                                      //Input parameter for SQL command    
                 char   ch  = 'a';                               //user input into query     
                   List<String> names = new ArrayList<>();               /* Prepare to get multiple rows */        
                pstmt.setInt(1, Integer.parseInt (in_id));             // Add parameter and execute          
                  String name= "john";                                                         
                 char   chr  = 'a';                               //user input into query     
                    names.add('John');                                      /* add multiple rows */        
               pstmt .setString(2,name);                                /* Set the second argument for prepared statement*/         
             if (ch != null && name!=  "") {                              /* Check user inputs and execute command again  */        }            else{                        System.out.println("No User selected");     return;         }}                     });