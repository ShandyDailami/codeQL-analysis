import java.sql.*;  // Import the required Java libraries/classes  
public class java_44924_JDBCQueryHandler_A08 {   
 public static void main(String[] args) throws SQLException, ClassNotFoundException{    
      String url = "jdbc:mysql://localhost:3306";      
        Properties props  = new Properties();  // Define the properties for connecting to database  
         props.setProperty("user","<username>");    // Set your MySQL username here         
         props.setProperty("password", "<Password>");     //Set Your Password Here           
         String dbName ="test";      /* select any name from the following list */            
        Class.forName(dbName);  / load 'system' database, Mysql databases are loaded by this statement*/             
   Connection conn =  DriverManager.getConnection (url , props );     // get connection to mysql    .        
      Statement stmt = null;       /* declare a static SQL statement variable */       
          try{            /****************/           begin transaction             ****************/                       
                String sqlQuery="SELECT UserID FROM Users";  // select all users from database.              
                  PreparedStatement pstmt =  conn .prepareStatement(sqlQuery);   /* prepare the SQL statement for execution */    stmt =conn.createStatement();         
                 ResultSet rs  = pstmt.executeQuery ( sqlQuery );           /********* execute and get result set *****/       while  (rs != null && rs .next() ) {      //iterate through the rows of a query-set             }         stmt = conn.createStatement();         
        /* close all connections */               if(conn ==null ||stmt==null) throw new SQLException("Error unable to connect or execute statement");       try{     /****** open connection and start transaction **********/   conns= DriverManager .getConnection ("jdbc:mysql://localhost/test", "user","password") ;    conn.setAutoCommit(false);          
        /* add some order for a user */            String insertOrderQuery ="INSERT INTO Orders (UserID) VALUES ('1')";   pstmt =  conns .prepareStatement  (insertOrderQuery );       int rowsInserted=pstmt.executeUpdate();          if (!conns.isAutoCommit()){        /* commit the transaction */    conn.commit(); }    
         System.out.println ("Rows inserted : " +rowsInserted);   /****** end of script *********/                  return;            //Exit main method             }}  catch (Exception e) {e . printStackTrace( );}           finally{                 if ((stmt != null)) stmt .close();     
         /* Close the statement */                try{(conn).close() ; }catch  
          (SQLException se){    /********** exception handling for JDBC *****/        System.out.println ("Error in closing connection" +se);     }}  catch(ClassNotFoundException cnfe) {      /*exception to handle invalid or unknown database name */       system . out . println("Invalid Database Name "+cnfe );   }