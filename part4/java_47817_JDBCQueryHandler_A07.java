import java.sql.*;
public class java_47817_JDBCQueryHandler_A07 {    
    public boolean validateUser(String userid , String password)  throws SQLException{        
        try (Connection conn = DriverManager.getConnection("<database_url>", "username","password");            
            Statement stmt=conn.createStatement())         
           )      
              {  
                // Execute query to check if user exists in the database   
                 ResultSet rs =  stmt.executeQuery(  "SELECT * FROM users WHERE username ='" +userid+ "' AND password  = '"  +password+  "' ");    
                   int count=0;      
                  while (rs.next()) {     
                      // if user exists, increment the counter and break from loop           
                    ++count ;             System.out.println( "User Found" );break;}         return true;    }              else{   ---------if not found then print message--------------          try       (PreparedStatement pstmt = conn .prepareStatement("INSERT INTO users VALUES (? , ?)")) {     
                         //set the parameters and execute it        if(count==0)     System.out.println("\n User Not Found, Inserting into database...");pstmt.setString(1, userid ); pstmt.setString(2, password  ;   }         conn .close();return false;}}   
                 catch (SQLException e){              throw new SQLException("Something went wrong while connecting to the Database");}       finally {     //Ensuring resources are closed properly          try{ if(!conn.isClosed())conn.close():System.out.println("\n Connection is already Closed" );}}
               }  catch (SQLException e)              throw new SQLException("Cannot open connection to the database");}   close {            //Ensuring resources are closed properly          try{ if(!stmt .isClosed()) stmt.close():System.out.println("\n Statement is already Closed" );}}
               catch (SQLException e)              throw new SQLException("Cannot execute statement on the database");}   }  // end of validateUser method     void main(String[] args){         try {validateUser ("user1", "password") ; System.out .println("\n Successfully Authenticated" );}}catch (SQL Exception e)          system out put println("Error while trying to authenticate: ",e);}