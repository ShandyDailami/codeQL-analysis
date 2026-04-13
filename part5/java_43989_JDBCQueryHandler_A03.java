import java.sql.*;
public class java_43989_JDBCQueryHandler_A03 {   //Replace this with the name you want for your handler, e.g., QueryExecutorImpl or something similar
    private final String url;     //This should be securely managed - ideally through a properties file not hardcoded into source code 
    private final String userName;      //The same goes here as well with security measures in place  
    private final String password;      
        
        public java_43989_JDBCQueryHandler_A03(String url, String userName , String password) {          
            this.url = url;             
            this.userName= userName ;         
	    this.password=  password;}  //Security measures to protect against injection should be placed here   
            	  
        public ResultSet executeQuery (String query) {     
         try{                        
                 Connection conn =  DriverManager.getConnection(url, userName , password);          
                  PreparedStatement pstmt =conn .prepareStatement(query );          //This is where the injection point would be      
		  return   pstmt.executeQuery(); }            catch (SQLException e) {              System.out.println ("Error executing query " +e);}             finally{if(!conn==null){try { conn.close();}}catch(SQLException ex){ex.printStackTrace()}; }}
		    return null;  //Returning a ResultSet from your method, you should handle this properly in real code too!              	     }     	       	}