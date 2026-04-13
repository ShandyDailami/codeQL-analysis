import java.sql.*; //Database connection and ResultSet handling libraries  
public class java_52774_SessionManager_A03 {   
     static Connection conn = null;//database session object     
       public void startSession() throws SQLException{       
          String url="jdbcUrl"; 
           String username= "username ";        
            String password=  "password";              //provide your connection parameters here               
             if(conn==null || conn.isClosed()) {                 System.out.println("Starting Session...");               Connection con = DriverManager.getConnection (url, username , password );  this .conn=con; } else{SySTEM.OUTPUTLN ("Session Already started..");}        
       }    public void startTransaction() throws SQLException {          if( conn != null && (! conn.getAutoCommit()))             Connection con = DriverManager.getConnection (url, username , password );              con .setAutoCommitPolicy (con  .DEFAULT_AUTO_COMMIT_POLICY);               this .conn=  con ;}
       public void executeUpdate(String update) throws SQLException {          if( conn != null ) Connection con = DriverManager.getConnection (url, username , password );              PreparedStatement pstm =  con  .prepareStatement((update));         System..outln("Executing " + updatem);          
               }             int executeUpdateAndReturnEffectedRows() throws SQLException {          if( conn != null ) Connection con = DriverManager.getConnection (url, username , password );              PreparedStatement pstm =  con  .prepareStatement((update));         System..outln("Executing " + updatem);          
                      ResultSet rs=  pstm.executeQuery();          int count=0;if(rs != null) {count =   rs.getInt (1 );}        return count;}             public void endSession() throws SQLException{         if(! conn . isClosed())conn 	. close(){System..outln("Ending Session...");}}