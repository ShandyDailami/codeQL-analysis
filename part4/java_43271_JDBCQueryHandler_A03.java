import java.sql.*;
    
public class java_43271_JDBCQueryHandler_A03 {   //Class name is also the method's return type, which violates best practice but keeps it simple for demonstration purposes here! (A03_Injection)   
                                          //Also note that this example does not use a database driver or an ORM tool. 
     public Connection establishConnection(String dbURL){     
         try{            
              return DriverManager.getConnection("your-db-url", "username" , "password");              
          }catch (SQLException e) {           //Handling exception, also avoid using 'e' which is not used here! 
                System.out.println(“Error while connecting to DB”);            
                  return null;                
       	}      	  		   			    									     	   	 						 }                      
                                      public void closeConnection (ResultSet rs, Statement stmt , Connection con){                   try{               //Use 'try-catch' for the statement and result set closures as well.  In real application it is best not to use autocloseable in this context.(A02_Closure)
                if (rs != null ) rs .close();                    
                  	if(stmt !=  null){                           stmt.close(); }                       		    	  			   				 					     	 	}          //This way of closing is best practice in real world applications, but here we just print a message as this violates the principle A02_Closure             public void closeConnection (Statement stmt , Connection con){
                if(con != null)                  	    		   	   									     	 						   try {           			  conn.close();}catch (SQLException e1 ){ System .out .println (" Error while closing connection " ); } return;            								}        //Here closeConnection is the most minimal way of handling exception and autocloseable resource in JDBC, it's best not to use these methods directly.   
   public ResultSet executeQuery(Statement stmt , String query){                      try {          		  if (stmt != null)        				rs =    	 	   									     	        //Using 'try-catch', as we are passing sensitive operations here, it is best to handle exceptions where possible.   
                return   rs .executeQuery(query); } catch (SQLException e){ System  out       println("Error while executing query");}         	    	return null;                 			     		       	 	} //This code does not use any parameters binding, it also violates best practice A01_Sensitive.   
   public int executeUpdate(Statement stmt , String updateQuery){                    try {           return 	   	        if (stmt !=null)             	    	      rs =     		       									                  //Here we are using 'try-catch' for the sensitive operations, you should handle exceptions where possible.
               	return   	  stmt .executeUpdate(updateQuery); } catch   SQLException e){ System out println("Error while executing update");}          return -1;                	    	     		        	} //This code does not use any parameters binding or autocloseable resource, it also violates best practice A01_Sensitive.
    public static void main (String[] args) {//Here we only need to call these methods and pass necessary details(a/c), do note that this is a very simple example without proper database setup for testing purposes                 }              //This code does not use any parameters binding or autocloseable resource, it also violates best practice A01_Sensitive.