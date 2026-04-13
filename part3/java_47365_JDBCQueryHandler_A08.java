import java.sql.*;   // Import necessary Java packages like DriverManager, Statement & PreparedStatement   
                   
public class java_47365_JDBCQueryHandler_A08 {    
      private static final String url = "jdbc:mysql://localhost/test";      
	  private static final String username="root";       	
	   	private static  final String password= 	"password1234567890ABCDSafety!";   		  			    				     	     	       					                   .	.`(.,. `..,,. ,'.' '. ', '-.+''', -.- '-';'.-'-=-- ..... --- ... 
	   	                            public static void main (String[] args) {       							      	 						           if (!connectDB()) System.exit(-1);      }  		   					     private static boolean connectDB()	{				         try{			                getConnection(url, username , password );                    return true;           	     	} catch	(SQLException e){ 	System.out .println("Database connection failed." +e	.getMessage());	return false;}
	   	 							      protected static Connection getConnection (String url, String userName,    		  			   						String passWord) throws SQLException {				        return DriverManager.getConnection(url ,userName ,""+passWord);	}	 } };