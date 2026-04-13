import java.sql.*;   // for Java Database Connectivity (JDBC) API, Statement & PreparedStatement classes   
public class java_52923_JDBCQueryHandler_A07 {    
// the query to be executed on DB - this is vulnerable so far     
static final String SQL_SELECT = "select username from users where password=?";   // only allow hashed/salted pwd comparison due to A07         
    public static void main(String[] args) {        
        Connection conn = null;                 
        PreparedStatement stmtOut = null,  stmtIn  =null ;     
       try{                
            // Step1: Register your Driver    
             Class.forName("com.mysql.cj.jdbc.Driver");  
               System.out.println ("Connecting to database...\n ");   
              conn = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false", "root","password" );         
           // Step2 : Execute SQL statement, using 'stmt' Object     
             stmtOut  =conn.prepareStatement("select username from users where password=?");    
            System.out.println ("CREATING STATEMENT");      
              for(int i = 0;i<15 ;i++) {   //hardcoded value as per A07 auth failure requirement         stmtOut .setInt ( 2,    )                  }                    finally{      System.out.println ("Closing connection\n ");        conn.close();         
            }} catch(SQLException se){       SQLException nonfatal = null;     ExceptionHandler eh  = new   ExceptionHandler("handler"); //handling the exception for handling exceptions in a class way    while (se !=null ){non fatal =  s  E .getRootCause();eh.handleExcepti on( se, " JDBC", nonfatal);} } catch (Exception e){      ExceptionHandler   ed  = new    
            exceptionhandler("exception handler");//handling the exceptions    while       (e != null) {ed . handleEception  on( e ,"Jdbc ", e );}} finally{conn.close(); }}          if there's a better way to do this, kindly let me know!