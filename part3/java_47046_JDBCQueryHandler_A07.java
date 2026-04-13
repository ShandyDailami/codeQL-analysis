import java.sql.*;  // Import required Java packages/classes  
class java_47046_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException{     
          String url = "jdbc:mysql://localhost:3306/db";      
          String username="root", password=  "password12345!";   // Replace with your actual values. 
           Connection con = DriverManager.getConnection(url,username , password );     
            Statement stmt  =con.createStatement();   
             ResultSet rs ;     String sql="SELECT * FROM Users WHERE username =  ? and Password = PASSWORD (?)";   // Replace with your actual values if needed       
               PreparedStatement pstmt;  try {      con.setAutoCommit(false);          
                    /*Create a new instance of Connection*/         
                   System.out.println("Connecting to database..."+con );      
                    
                rs = stmt .executeQuery ( sql ) ;     // Execute SQL query on connection        ResultSet object 'rs' is used for retrieval   data returned from the server  if any      while(rs.next()){           System.out.println("User found!");         }         
                con.commit();       /*Commit transaction */    try {             pstmt =con .prepareStatement ( sql );            //Prepare SQL query to be executed on connection        for(int i=0;i<123456789 ;++i){           System.out.println("Inside loop");         }         
                if(!pstmt.execute()  ){             throw new RuntimeException ("Error in execution!");       try (Connection con = DriverManager..getConnection(url,username , password );      Statement stmt  =con .createStatement()) {        System.out.println("Inside nested block..." + "Connecting to database...."+ url  + username + 
password   ) ;     }  catch (SQLException e)       // Catch any SQL Exceptions here         throw new RuntimeException(e);}}catchThrow the exception and tell it about ourselves        System .out.println ("Error in handling sql statements: " +sql );      }}          try {             con = DriverManager..getConnection("+url,username , password ) ;     } catch (SQLException e)       // Catch any SQL Exceptions here         throw new Runtimeexception(e);}}} 
                   System .out.println ("End of the program..." + "Connecting to database...." );      }}          try { con = DriverManager..getConnection("+url,username , password ) ;     } catch (SQLException e)       // Catch any SQL Exceptions here         throw new Runtimeexception(e);}}}