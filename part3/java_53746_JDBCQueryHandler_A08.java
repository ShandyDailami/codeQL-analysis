import java.sql.*;  // Import Statements Here  
public class java_53746_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{      
         String url = "jdbc:oracle://localhost/XE";      // Add your Oracle URL here       
         Connection conn=null;          
            try  {                  
             DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());  
              /* Create a connection */    
                conn = DriverManager.getConnection (url,"username","password");                 
                 PreparedStatement pstmt  = null ;    //Defining your query here           try  {               String sql="INSERT INTO EMPLOYEE(ID,NAME,DEPARTMENT) VALUES(?,?)";           
                     conn.setAutoCommit(false);                                                         /* Open a connection */       if (conn != null){     System.out.println("Connected to the database");   }        try{  pstmt = conn.prepareStatement ("INSERT INTO EMPLOYEE(ID,NAME ,DEPARTMENT) VALUES(?,?) ");   
                       // Use setter methods for setting values          /* Execute an SQL statement */         int rowsInserted=pstmt.executeUpdate();   System.out.println("Records inserted: "+rowsInserted); }catch (SQLException e){  throw new RuntimeException ("Cannot execute insert operation",e );}
                       // Handle any errors that may occur    catch(SQLException se) {se.printStackTrace();}} try{ conn.close();   /* Close connection */     if (!conn.isClosed()) System.out.println("Disconnected from the database"); }catch (SQLException e){e.printStackTrace()}
                  }}        // End of Main Function  catch(Throwable t) {t.printStackTrace():}};   };    });