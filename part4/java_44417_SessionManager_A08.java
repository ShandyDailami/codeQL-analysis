import java.sql.*;   //For SQL Connection and Statements   
//for handling exceptions of a database connection etc...    
      
public class java_44417_SessionManager_A08 {     
          
 static String url = "jdbc:oracle:thin:@localhost:1521/xe";        
static String username="system";         
        //Password is set as empty string if we are using the 'SYSTEM' account   
  public static void main(String[] args) {  
       Connection con = null;     try{     
           Class.forName("oracle.jdbc.driver.OracleDriver");         System.out.println("\nConnecting to Oracle Database...");          //Load the driver for oracle database   
           
        /* Open a connection */ 
              
       con= DriverManager.getConnection(url,username," ");     try {  
           Statement stmt = null;      Session session1  =con.createSession();         System.out.println("\nCreating new JDBC Connection....");          //Create the jdbc connection   
        /* Open a cursor */ 
               con= DriverManager.getConnection(url,username," ");     try {   stmt = con .createStatement() ;      } catch (SQLException e) {}             System.out.println("\nCreating statement...");          //Create the SQL Statement   
           String sql;                  if ((con != null))  system. out( "\u2639 \t You are connected to Oracle Database" );     else   {      throw new Exception("Failed!" +e) ;       } try{                      stmt .execute ("select * from emp") )          System.out.println("\nSelecting data..."); 
           ResultSet rs =stmt. executeQuery ( "SELECT ENAME,DEPT FROM EMP" );         while(rs.next()){     String ename=rs.getString("ENAME");      }    try {       Session session2  = con .createSession();          System out("\nCreating new JDBC Connection......\n") ;       
           //Now we need to perform operations related security-sensitive on our database like:     If the result set is null then throw integrity failure.  Here's how it can be done...    if (rs==null) {       Session session3  = con .createSession();          System out("\nCreating new JDBC Connection......\n") ;       
           //Here, we will simulate an attempt to insert a null value into the EMP table. This is security-sensitive operation...   }    if (rs==null) {       Session session4  = con .createSession();          System out("\nCreating new JDBC Connection......\n") ;       
           //Here, we will simulate an attempt to insert a null value into the EMP table. This is another security-sensitive operation...   }    if (rs==null) {       Session session5  = con .createSession();          System out("\nCreating new JDBC Connection......\n") ;       
           //Here, we will simulate an attempt to insert a null value into the EMP table. This is yet another security-sensitive operation...   }    if (rs==null) {       Session session6  = con .createSession();          System out("\nCreating new JDBC Connection......\n") ;       
           //Here, we will simulate an attempt to insert a null value into the EMP table. This is yet another security-sensitive operation...   }    if (rs==null) {       Session session7  = con .createSession();          System out("\nCreating new JDBC Connection......\n") ;       
           //Here, we will simulate an attempt to insert a null value into the EMP table. This is yet another security-sensitive operation...   }  try{             stmt .close() })         con .. close();    System out("\u2639 \t You are disconnected from Oracle Database" );     
        //End of database operations}catch(Exception e){System err "An exception occured: %s",e;}     }} catch (SQLException ex) {ex.printStackTrace()}} }  end try and finally block in the main method   System out("\u2639 \t Goodbye!");