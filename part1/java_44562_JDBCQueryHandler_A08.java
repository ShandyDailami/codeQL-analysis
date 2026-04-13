import java.sql.*;   //for database connection management, SQL exceptions etc., are handled by these classes.   
                    
public class java_44562_JDBCQueryHandler_A08 {    
       public static void main(String[] args) throws SQLException{       
           String url = "jdbc:mysql://localhost/test";         //your db URL here  
           String userName="root";      //Your username  for DB connection   
           String password="password@1234567890!";     // Your Password Here. Be sure to keep your database credentials secure      
            
        Connection con = null;         //connection object   using 'try-catch' block will help in handling SQLException 
                                         and also prevent sqlInjection attacks   
           try{         
               System.out.println("Connecting To Database...");     
               
                   //Establishing connection    
                 con=DriverManager.getConnection(url,userName , password );            
                    
                    if (con != null) {         //Check Connection status  for security-sensitive operations  
                            System.out.println("Connected To Database");       
                         }else{           
                              throw new SQLException("Cannot Establish a connection with the database server!");     
                             }                 
            
           }catch(SQLException sqle){         //Catching Exception and displaying Error Message    
               System.out.println("\n Connection Failed! " + "\n"+sqle );      
            }   finally{          /* This block will execute whether the try-or catch finishes in a normal or exception situation */       
                if(con != null && con.isClosed() == false){     //closing connection after use   
                    System.out.println("Connection Will Be Closed.");        
                     con.close();               }                   };          }}                 `;