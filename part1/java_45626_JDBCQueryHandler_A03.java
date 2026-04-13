import java.sql.*; // JDBC driver name and SQL query interface    
  
public class java_45626_JDBCQueryHandler_A03 {     
      
    public static void main(String[] args) throws ClassNotFoundException, SQLException{        
        String url = "jdbc:mysql://localhost/testdb";         
           //Database URL           
              
        Properties props = new Properties();    
             // Database credentials               
                
        Connection con=null;     
              //Declaring connection object of class DriverManager      
                  
  Class.forName("com.mysql.jdbc.Driver");  
          /* registering MySQL driver */   
          
         System.out.println("\n Connecting to database...");    
        con= DriverManager.getConnection(url,"root","password");      // Getting connection object and creating a statement            
           
       String SQL = "SELECT `username`, email FROM users WHERE id > :id";   /* your select query here */   
         PreparedStatement pstmt =  con.prepareCall(SQL);  /**/     ** preparing sql query for execution using '?' placeholders **/     
          // Using ':' as parameter marker      
        int i=1;              // Setting the id value of paramMarker to integer type  
             System.out.println("Using setter method");    if(con != null){         con.setAutoCommit(false); }     pstmt .setInt(i++, 2503674891L );       // Setting int paramMarker to integer type  
             System.out.println("Using setter method");    if (con != null ) { con.commit();}        try{            /* execute the statement */           pstmt .executeUpdate() ;         }catch(Exception ex){          printSQLExcetion(ex);  //print SQL exception information     
              System.out.println("\n JDBC successfully executed.");    finally{   if (con != null) { con.close();}     try {           /* execute another query */            pstmt .executeUpdate() ;         } catch (Exception ex)          printSQLExcetion(ex);  //print SQL exception information     
              System.out.println("\n JDBC successfully executed.");    }}        private static void   printSQLExcetion     (Throwable t){           /* this method is used to log any database specific error */         t .printStackTrace();          } catch (SQLException sqlEx) {                //Handling SQL exception      
              System.out.println("\n Error in backing up table");      sqlEx .printStackTrace() ;        }}`  END of code