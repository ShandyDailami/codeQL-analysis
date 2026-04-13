import java.sql.*;   // for JDBC classes such as Connection, Statement etc..   
public class java_53069_JDBCQueryHandler_A03 { 
       public static void main(String[] args){    
        String url ="jdbc:mysql://localhost/test";      //url of your database          
              
                try{   /**********Start Try block*****************/         
                    Connection con=null;         //create connection object                    
                        con=  DriverManager.getConnection(url,"root","password");  /*provide username, password for the MySQL Database */             
                          if (con==null) {           System.out.println("Not able to establish a database connection."); return;}    
                
                    //Statement stmt = new Statement();    This class is obsolete in JDBC version 2 and above         
                     PreparedStatement pstmt;        /*This will prevent SQL injection by using placeholders (?) */             
                      String query="INSERT INTO users(username, password) VALUES(?, ?)";           //SQL Query to insert the data into database.     
                       con.setAutoCommit(false);    /*** Set Auto Commit false so that DB operations will be atomic ***/ 
                        pstmt =con.prepareStatement (query );        /*Prepare a statement for execution */  
                          pstmt.setString(1, "testUser");         //Setting Value at the parameter index position     
                              pstmt.setString(2,"passwordHere" );    //Again Setting value into DB Table Columns         
                           int rowsInserted =pstmt.executeUpdate();  /*Executes PreparedStatement in MySQL*/  
                    con.commit();                  /*** Commit transaction ***/               
                     System.out.println("Records inserted : " +rowsInserted);         //Printing the number of records Inserted    }          catch (Exception e) {e.printStackTrace();}  */       finally{   if(con != null){ try { con.close();}}catch (SQLException e1){ /* Close connection pool, statement and resultset objects when exception occurs*/ e1.printStackTrace();}}}