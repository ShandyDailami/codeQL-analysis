import java.sql.*; // Import the required classes from Oracle driver package  
class java_44005_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{     
           String url = "jdbc:oracle:thin:@localhost:1521:xe";       
           String username="username_here";      
           String password="password_here";   //Here, replace 'your' and '_there'.   
    
            try (Connection con =  DriverManager.getConnection(url , username , password)) {        
                System.out.println("Successfully connected to database");  }     
              catch (SQLException ex)        {       ExceptionHandler.handleExceptions(ex);}          return;    },     //Catch block for exceptions handling   }}catchblockforexceptionshandling})}}}}}//End of main method endofmainmethodendforsqlcommands};  };