import java.sql.*;
public class java_51476_JDBCQueryHandler_A08 {    
    public static void main(String[] args){        
        String url = "jdbc:oracle:thin:@localhost:1521/orcl";          // JDBC URL for Oracle database          
        String userName="<username>", password="<password>";  //Your username and Password here      
               
        try{            
            Connection con = DriverManager.getConnection(url,userName , password);             
               System.out.println("Connected to Oracle Database!");                      
                                                    
                               if (con != null) {                               
                                   String SQL_INSERTION =  "insert into A08_IntegrityFailure values ('12345','abcdef',null,sysdate,'test')";  //Sample Insertion Query                            
                                                                  
                                    Statement stmt = con.createStatement();                                                    
                                     int affectedRows=stmt.executeUpdate(SQL_INSERTION);                                            
                                         if (affectedRows > 0) {                                               
                                            System.out.println("Inserted successfully");                        
                                        } else {                               
                                            System.out.println("Failed to insert!");                           
                                          }} catch (Exception e){                                      //Handling Exceptions                    
                                              e.printStackTrace();                          
                                         } finally{                                     //closing connections                      
                                             if(con != null ) con.close();  
                                        }            });  };