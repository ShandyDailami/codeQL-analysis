import java.sql.*;   // Import Java SQL classes    
public class java_51796_JDBCQueryHandler_A08 {    // Declare a new public class named "JDBCQueryHandler"      
      private Connection connection;             
        try{                   
             Class.forName("com.mysql.cj.jdbc.Driver");         
               this.connection = DriverManager.getConnection( “Your_MySQLURL”,   // MySQL URL and username/password   
                      "username",                            
                       "password" );                  
         }catch (ClassNotFoundException e){    
             System.out.println("Please select a driver that is available.");     
               e.printStackTrace();             
          }                   
       public void login(String username, String password) {    // Method to log in the user       
           try{                                                            
                  PreparedStatement preparedstatement =  connection .prepareStatement  ("select * from users where name = ? and pwd  = ?");    
                      preparedstatement.setString (1 ,username );  
                      preparedstatement.setString(2, password) ;    //Set parameters in the query        
                       ResultSet rs=preparedstatement .executeQuery();      // Execute Query       Run a select statement using connection        if (!rs.next()) {          System.out.println("User not found" );     } else{              String name =   rs.getString(1);           System. out. println ("Welcome " +name+", you are logged in successfully");   
                       // Continue with the rest of your program      
                   } catch (SQLException e) {         
                      System .out.println("Error occurred while logging into system" );     e  .printStackTrace();   }}                  else{              String name = rs.getString(1);           System. out. println ("Welcome " +name+", you are logged in successfully"); }}}catch (SQLException ex) {ex.printStackTrace()}