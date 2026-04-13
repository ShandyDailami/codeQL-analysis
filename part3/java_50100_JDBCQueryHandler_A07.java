import java.sql.*;   // import necessary Java packages, e.g., Connection, Statement etc..   
public class java_50100_JDBCQueryHandler_A07 {    
  public static void main(String args[]) throws Exception{     
         String url = "jdbc_url";      
		String username="username";        string password ;   // your actual database credentials here.         
		 Connection conn;               PreparedStatement pstmt;                ResultSet rs;    	        try {           
			  Class.forName("oracle.jdbc.driver.OracleDriver");    /* Oracle JDBC Driver */                  	         url=url ;   username =username, password =  //password for your database connectivity               conn=  DriverManager.getConnection(url ,username,password);           pstmt  =conn .prepareStatement ("SELECT * FROM EMPLOYEE WHERE AGE > ?" );       
			pstmt.setInt (13) ;              /* set the parameter */                   	         rs=pstmt.executeQuery()   // run query                     while(rs.next()) {                 System.out.println("ID = " + rs.getString ("EMP_NAME")); } 
			} catch {} finally{}            try{conn.close();}catch (Exception e){e.printStackTrace();}              if ((pstmt) != null) pstmt .close() ;                    conn =  // end of the connection here; }}                 Logger log = ...           /* or use a logging framework, like SLF4J */