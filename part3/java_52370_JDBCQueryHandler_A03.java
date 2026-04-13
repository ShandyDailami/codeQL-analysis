import java.sql.*;
public class java_52370_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost/test"; // your database url and name, replace with actual values 
    private static final String USERNAME="root";//your username for the MySQL server or other type of DBMS (replace 'root' if you are not using root user)  
    private static final String PASSWORD = "password"; // your password to connect database. Replace with actual values 
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);        
    }     
  
public void close(ResultSet rs) {
       if (rs != null){	try{				rs.close();			}catch(SQLException e){}										} 
                  }}    
                         
                            public static void main(String[] args){                            	        try                	{            	   	  Connection conn = new JDBCQueryHandler().getConnection()    ;                    	      } catch (SQLException ex) {        	ex.printStackTrace();      		  			             	}        finally                {{                  if(!conn .isClosed())          									  close(null);            }}
                             });             };