import java.sql.*;  // Import the necessary classes from JDBC library  

public class java_51567_JDBCQueryHandler_A08 {   
      
        public static void main(String[] args) throws SQLException{    
             String url = "jdbc:mysql://localhost/db";     
             String username="root";  // replace with your own database user name.  
             String password="password";//replace the above line as per actual mysql root account's pass-word   
                 
            Connection con  = DriverManager.getConnection(url,username , password);         
              Statement stmt = null;     
               try {  // Create a statement object    
                 if (con != null)   {       System.out.println("Connecting to database");    } else{System.out.println("Not able to connect the Database ");}        
                    stmt =  con.createStatement();        boolean done = false;      char[] chars  = {'a', 'b'};     String stringVal   = "Into World";  int anInt  = 5 ;    java.util.Date aDate= new java.util.Date()；      
                  // Execute the SQL query         try {        stmt = con .createStatement();      ResultSet rs  = null;          if (stmt !=null)           done =  false;} catch(SQLException se){se.printStackTrace();}  }    while (!done);   System.out.println ("End of program.");    
                     // do not forget to close the statement and connections!        try { stmt = con .createStatement();       if (stmt != null)         done =  false;} catch(SQLException se){se.printStackTrace();} while (!done);   System.out.println ("End of program.");
             } finally{  // Always close the statement, connection when you are finished using them!     stmt .close ( ); con .close() ;      }}    if ((stmt != null) &&(con !=  null)) { done = true;}} catch (SQLException se){se.printStackTrace();}