import java.sql.*;   // import Statement, Connection classes 
public class java_51772_JDBCQueryHandler_A03 {   
      
     public ResultSet executeSelect(String query) throws SQLException{       
         String url = "your_url";         
		String driverName  ="com.mysql.cj.jdbc.Driver";   // add your own MySQL Driver Class and URL in the code below 
		 Connection con=null;    //variable for connection object          
			 try {     //begin of a Try block        
					//step1:register JDBC driver         					       	 	      
						 System.out.println("Registering JDBC Driver");     
							 Class.forName(driverName);                 		 	   	       	     
								 con=DriverManager.getConnection(url,"username","password");               			   				     //step2:Establish connection with the database  	        					       	 						       } catch (Exception e) {          System.out.println("Failed to register JDBC Driver.");      return null;} 
		 ResultSet rs = con.createStatement().executeQuery(query);   	//executing select query     try and get result set from the database        	  					       	 			       } catch (SQLException e) {System.out.println("Error in executing SQL..."+e); return null;} 
		 //step3:Process ResultSet object         				     	return rs;    }}//end of main method     public static void main(String args[]){   try{JDBCQueryHandler jdbc=new JDBCQueryHandler();jdbc.executeSelect("your_query");}catch (Exception e) {e.printStackTrace()}}