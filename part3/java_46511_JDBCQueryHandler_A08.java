import java.sql.*;   // For ResultSet & Statement Interface   
                    
public class java_46511_JDBCQueryHandler_A08 {    
 public static void main(String[] args) {        
          String url = "jdbc:mysql://localhost/test";          
            String username="root";      
             char passwordCharArray [] =  {'p'};  // you need to insert your actual root pass  
             
      try{              
        Connection conn = DriverManager.getConnection(url,username,"");                
         System.out.println("Connected To Database.");                    
          
          String query="select * from Employee";      
            Statement stmt  =conn.createStatement();                     
              ResultSet rs =  stmt.executeQuery (query);                 
             while(rs.next()){                  
                System.out.println("Employees ID: "+rs.getString('id'));    //You need to change the column names according to your table structure  
                                                            }        
        conn.close();    
           } catch (SQLException e) {              
            e.printStackTrace();            
          }                    
      System.out.println("Closing Connection."); 
    }}       //End of main function body