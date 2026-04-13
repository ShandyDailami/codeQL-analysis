import java.sql.*;  // Importing necessary libraries for JDBC (Java Database Connectivity) operations;  
public class java_44293_JDBCQueryHandler_A03 {    
    public static void main(String[] args){        
        String url = "jdbcURL";         
		String userName =  "user" ;          
	 	String password=  "";              //password in the system is a sensitive operation and should never be hardcoded 		  				//also, we're using empty string for simplicity. In real-world application you need to handle this as per your environment     	   	    									       };         	     
        try {               
            Connection con=DriverManager.getConnection(url , userName, password);         //connecting the database          		 				};             	       	  }catch (Exception e){             println("Error in connecting to Database "+e) ;                          	     }}     	    });    };      	      );