import java.sql.*;
public class java_52326_JDBCQueryHandler_A03 {  // begin main method block    
    public static void main(String[] args) throws Exception  
        {         
            String url = "jdbc:mysql://localhost/testdb";          
            
                try (Connection conn = DriverManager.getConnection(url, "user", "password")){              //begin connection block     
                    Statement stmt=conn.createStatement();                                       
                    
                        String sql1 =  "SELECT user_id FROM users WHERE email LIKE ?";                     
                         PreparedStatement pstmt = conn.prepareStatement (sql1);                         
                            for(int i= 0 ;i<5; ++i){                                                       //parameterized query with placeholder                  
                                char letter= 'A'+i;  
                                  String mailId =  "" +letter  + "@example..com";  # no injection here, just syntax                    
                               pstmt.setString (2 ,mailId);                                                  
                              ResultSet rs =pstmt.executeQuery();                                   //run query and get result set             
                                while(rs.next()){                                                       //process each row of the results        
                                    int id=rs.getInt("user_id");                                      #no injection here, just syntax              
                                     System.out.println ("User ID: " +id);                            print user details                          }                                                                     catch (SQLException ex) {                   sqlError(ex); }}                                                      try{                             pstmt = conn .prepareStatement  // parameterized query with placeholder         2 ,mailId );                    ResultSet rs1=pstmt.executeQuery();                     while  
>rsextractions    all user details in each step      }catch (SQLException ex) {sqlError(ex);}}                                                  ^ Canceled! — No line to cancel, because it's not a terminal command execution point and no operation is specified. Type 'quit', or press the enter key if you want exit from this session: