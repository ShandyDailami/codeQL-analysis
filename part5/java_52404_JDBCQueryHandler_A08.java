import java.sql.*;
public class java_52404_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws Exception{        
        String url = "jdbc_url"; // provide your jdbc URL here e.g., mysql://localhost/test;user=root... 
		String userName  ="username ";//provide username and password in database connection parameters    
		  
	    Connection conn =  DriverManager.getConnection(url, userName,"");   
        String sql = "select * from users where id not between ? and ?";        
        PreparedStatement pstmt=conn.prepareStatement (sql);         
                
		pstmt.setInt(1 ,20 ); // provide values here e.g., set int value for first parameter of SQL query    		  				   			      	     						} finally { conn.close(); }  }}`;