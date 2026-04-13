import java.sql.*;
public class java_48644_JDBCQueryHandler_A07 {  // Starts the example (Assuming you named your file Main)  
    public static void main(String[] args){    
        String url = "jdbc:mysql://localhost/test";      // Replace with Your URL, DB Name Here      
         try{                     
            Connection conn=DriverManager.getConnection(url,"user","password");  ///Replace 'user' and password according to your database credentials   
              Statement stmt =conn.createStatement();  
             ResultSet rs =  stmt.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='" +password+ "' ");     //Assuming you have a table named 'users'  with fields userid, usernname and passsword   
              if(rs.next()){                      /// If the query finds any match in database then it will go inside this condition     
                  System.out.println("Authentication Successful");     // This is just to verify whether authentication was successful or not        } else {          System.out.printl "Invalid Username/Password" ;   }} catch (SQLException e) {           ///Catching any SQL Exception that may occur while executing the query   
             e.printStackTrace();  // This will print out detailed information about what went wrong     
        } finally{     conn.close();}                 //This is to close connection whether it was successful or not         }} catch (SQLException ex) {              ///Catching any SQL Exception that may occur while connecting the database   
          System.out.println("Cannot open database");               //If something went wrong here, this message will be printed       }  return;}}      });//Ends Main method   })     ;}}}`}));}})).close();)))").getBytes());})) .replace("\r","")))); }}