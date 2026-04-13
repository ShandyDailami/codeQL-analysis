import java.sql.*;   //Import necessary classes from JDBC library    
public class java_43227_JDBCQueryHandler_A08 {     
    public static Connection conn = null;        
      
        /* Function to create connection */ 
           private void establishConnection(){                 
               try{                  
                    Class.forName("com.mysql.cj.jdbc.Driver"); //Load the driver class         
                       System.out.println("\nConnecting to database...\n" +   "Reconnecting...");             
                           conn = DriverManager.getConnection(  Constants_DB.URL,Constants_DB.USERNAME ,    Constants_DB.PASSWORD );                  //Get a connection from the driver         
                            System.out.println("\nYou've connected to database!\n");                      }                       catch (Exception e){                        Logger.getLogger(A08_IntegrityFailure .class).  logLogs(Level.SEVERE,e);   }}                   public static void main(String args[]) {                     establishConnection();             //Create a new connection              A01a security sensitive operation                       try{                             conn.createStatement().execute("INSERT INTO Employee (EmployId , EName ) VALUES ('A', 'AA')");                    }catch(SQLException se){                            Logger.getLogger(A08_IntegrityFailure .class).logLogs(Level.SEVERE,se);                       }}