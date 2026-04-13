import java.sql.*;   // for Java Database Connectivity, ResultSet etc..
public class java_44518_SessionManager_A03 {    
    private static String url = "jdbc:mysql://localhost/test";     
    private static String username="root";       
    private static String password="@dmin12345!";   //change it as per your requirement.  For simplicity, I have used a hardcoded string for the purpose of this example . In real-world application you should never use such sensitive information (like usernames and passwords) in code unless they are environment specific parameters like URL or Database details etc
    private static Connection connection;   //declare class variable to hold reference  -connection.    
      public java_44518_SessionManager_A03() {        /* Constructor */ }        
      
public void openConnection(){          /** opens a database connection **/           try{            
            Class.forName("com.mysql.cj.jdbc.Driver");                //load MySQL driver class   com.mysql.*;                  Connection con = DriverManager .getConnection(url,username ,password);                     } catch (ClassNotFoundException e){System.out.println ("driver not found" +e );}catch  SQLException se1    { System. out. println("SQL Exception "+se2) ;}}  
       public Connection getConnection(){                   //returns the connection object, we will use this to perform queries on database           try{               return (connection = DriverManager .getConnection(url , username, password));} catch  SQLException se1    { System. out. println("SQL Exception "+se2) ;return null; }
       public void closeConnections(){                     //closes the connection object          if((conn !=null)) try{ conn.close();   /* end of code */}}      /**main method**/        public static  void main(String[] args){           SessionManager sm = newSession Manager ();         sm .openConnection() ;} }