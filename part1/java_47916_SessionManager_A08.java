import java.sql.*;
class java_47916_SessionManager_A08 {  
    private static final String URL = "jdbc:mysql://localhost/test"; //Change based on your setup, should match the db you are using (Test DB in this example)    
    private static final String USERNAME="root";  // Change to user root with sufficient privilege for creating session.  
    private static final String PASSWORD = "password";// Assuming default password is 'password' which matches above username, change as per your setup       
      
         public Connection getConnection() throws SQLException{    
             return DriverManager.getConnection(URL , USERNAME,PASSWORD);  //Returns a new connection to the database     
    }  
}              
public class Main {                
           private static SessionManager sm = null;         
            public static void main (String args[]) throws SQLException{                    
                    if (sm==null){                           
                             try{                             
                                     System.out.println("Starting up");                     
                                     //Initializing the session manager    	                                 
                                        Class.forName ("com.mysql.jdbc.Driver") ;  			   									 		     	 	    }                                                        catch (ClassNotFoundException e) {                         
                                         throw new ExceptionInInitializerError(e);                   };                            sm =new SessionManager();                      }}                             try{                               //try to get connection                          	     Connection conn=sm.getConnection() ;                                                                                     if(!conn.isClosed())                                                    System.out.println("connected"); 
                              else throw new Exception ("Cannot connect " +     		         			 sm);}}catch (Exception e) {e.printStackTrace();}                  }                           catch(SQLException se){se.printStackTrace()};                                                                               }}`java' and '