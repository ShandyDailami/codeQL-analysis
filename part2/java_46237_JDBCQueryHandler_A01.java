import java.sql.*;  // Import necessary classes from Java's standard libraries (like DriverManager)  

public class java_46237_JDBCQueryHandler_A01 {
    public static void main(String[] args){    
        String url = "jdbc:mysql://localhost/dbname";             
          
          try{            
            Connection con=DriverManager.getConnection(url,"username","password");  //Establishes connection with the database        
                                                                                  
                Statement stmt;                                                      
                     if (con != null){                                               
                         System.out.println("Connected to MySQL!");                   
                             } else {                                           
                                         System.err.println("Failed" );                      return;}              //Checking Connection                         
                            try{                                                                    
                                     "select * from users where name = ?" . replace ("?", "%s");                                                  stmt=con.createStatement();      
                                  ResultSet rs=  stmt.executeQuery(rs,userName);             }catch (SQLException e) {e.printStackTrace()}     // Executing SQL Query for User Name  
        }} catch (SQLException e){                                                                                                                 System.out.println("Error in connection: " + e );  };                  return;});               });                      
               `