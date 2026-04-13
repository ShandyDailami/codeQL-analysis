import java.sql.*;   //For Java Database Connection 
public class java_46343_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{       
            String url = "jdbc:mysql://localhost/test";        
              String username ="root";         
             String password="password1234@ABCD..!";  //Insert your real database credential  	    	   	       
           try {                   Connection con =  DriverManager.getConnection(url,username , password);                    System.out.println("connected");                             }       catch (SQLException e)      {System.err.print_stacktrace();}         finally{con=null;}}            	}