import java.sql.*;
public class java_45478_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {        
        try{            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");                        
           // Simulate user authentication to the database – replace 'user1' and 'passw0rd!' with actual values                    
               Statement stmt=conn.createStatement();            
                String SQL ="SELECT * FROM users WHERE username='"+args[0]+"' AND password='" + args[1]  + "'";              //replace user input                 
           ResultSet rs =stmt.executeQuery(SQL);              
            if(!rs.isEmpty()){                              //if there is a match, the program will print "Successfully authenticated"                        
                System.out.println("User successfully logged in");                       
             }else{                                          //otherwise it prints error message                                                   
                 throw new SQLException("Invalid username or password!");                      
            }             
           conn.close();                                        //closes the connection              
        }catch(SQLException e){                              //Catch exceptions for JDBC                 
          System.out.println("Error: " +e );                     
         }, () -> {System.out.print ("Closed Connection");} );             };                        
};