import java.sql.*;

public class java_47741_JDBCQueryHandler_A03 {  
    private static final String URL = "jdbc:mysql://localhost/test"; // change with your database info        
    
    public void start() throws SQLException, ClassNotFoundException{       
		String username="root", password= ""; 	//change accordingly. Use 'username' and '' for local testing      
		  			         	       					                  	     	   				                    	 		             // empty string as no extra properties are specified in the jdbc url    
        
            Class.forName("com.mysql.cj.jdbc.Driver"); 	// this will load MySQL JDBC Driver into your program, change 'localhost' with server name of database if different  	         	       		             			   	 				     	     					       // use the correct driver according to DB type and version
         }               
     public Connection getConnection() throws SQLException {       
            return DriverManager.getConnection(URL , username, password);          	   
	} 
                       
	public ResultSet executeQueryWithParams (String queryStr, Object... params)throws SQLException{     	         		      	       	 			  									    	     							             // use the '?' placeholder for each parameter in your sql string and add them into an array of objects. This will prevent SQL injection attacks by automatically escaping special characters
            Connection con = this.getConnection();                 	    Class c=params[0].getClass();                     String queryStr1  ="SELECT * FROM tablename WHERE columnname";//replace with actual values    	   // PrepareStatement pst =  (PreparedStatement)con .prepareStatement(queryString);
            PreparedStatement ps = con.prepareStatement(queryStr1 ); 		    for(int i=0;i<params.length ;i++){       				//loop through each parameter and set the value in place of '?'     									   }             // run query, no results returned yet
            ResultSet rs = ps.executeQuery();                      	ps.close();                  con .close();     return  null;                  		   	       	   	     	 	}              public static void main(String[] args) throws SQLException {         new VanillaJDBCQueryHandler().start() ;} }