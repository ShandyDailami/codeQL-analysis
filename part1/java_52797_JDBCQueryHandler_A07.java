import java.sql.*;   // Import necessary Java libraries for JDBC operations    
public class java_52797_JDBCQueryHandler_A07 {     
    public static void main(String[] args) throws SQLException{       
            String url = "jdbc:mysql://localhost/mydatabase"; 
            Connection conn;                     
            
          //Establish a database connection using JDBC. This is equivalent of MySQL Connector in Java    
           conn=DriverManager.getConnection(url,"username","password");      
        
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";   
            PreparedStatement pstmt =  conn.prepareStatement (sql);   //Prepare statement for SQL execution    
            
           /* Set parameter values and execute the query */     
          pstmt.setString(1, "testuser");      
          pstmt.setString(2,"passwordhash") ; 
         boolean authFailure = !pstmt.execute();   // Execute Query if authentication failed    
       
            /* If authentification fails then throw an exception */     
           if (authFailure) {              
             System.out.println("Authentication Failed!");                 
                } else{                  
                     System.out.print ("Successfully Authenticated");  // Prints Successfull message on successful authentication    };   });          Connection conn = DriverManager.getConnection(url, userName , password );      String sqlQuery="SELECT * FROM User_Details";     PreparedStatement pstm =  connection .prepareCall (sql);           
        }         catch  Exception e { System.out.println ("Exception occurred in database operations ");} //Handling Exceptions   };    }}`;