import java.sql.*;

public class java_43463_JDBCQueryHandler_A01 {    
    public static Connection getConnection() throws SQLException{  
        String url = "jdbc:mysql://localhost/mydatabase"; // replace with your db URL and credentials     
		String username="root", password= "";  //replace these values accordingly      
        		
	    return DriverManager.getConnection(url,username,password);     }   
   public static void main (String[] args) {       	 					         				             			            try{               						                  								     	          
             Connection conn = getConnection();                 	        if (!conn.isClosed()){                                                          System.out.println("Connected successfully");}                                                else                    println ("Failed to connect!");  }                                                                   catch (SQLException ex) {printStackTrace(ex)};        }}`