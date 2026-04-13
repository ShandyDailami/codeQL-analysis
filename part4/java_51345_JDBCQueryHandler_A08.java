import java.sql.*;  // Import necessary classes for JDBC and SQL Connection & Statement objects, ResultSets etc...  
    
public class java_51345_JDBCQueryHandler_A08 {   
       private String url;     
       private String userName;        
       private String password;           
       
       public void connect(String dbUrl ,  String username, char[] password) throws SQLException{             //Method for establishing the Connection         
              this.url =dbUrl ;  
		this.userName=username;   			//Assigning credentials to variables user name and Password    			       				        					     						                                                                      								              ​                 
	      if (password !=  null) {  // If password is not NULL, then set it else continue with empty string         	       	 	          	    this.password=new String(password); }             		   	//If the passed character array isn't Null assigning into Password variable       			  				
	      Connection con = DriverManager.getConnection (this.url , 	this.userName, ""); //Establishing connection        	       	                           	   							               					     ​              	}    								                                                                                        		                         	//Method for handling Security sensitive Operations related to Integrity Failure A08_IntegrityFailure
       }  
        public ResultSet executeQuery(String query) throws SQLException{  // Method For Executing the Query        	       	                            									     			                           								           ​     this.password);   		         	    Connection con = DriverManager .getConnection (this,url , userName,, password );       }               
}                                                                            	  ResultSet rs=con.createStatement().executeQuery(query)  //Executing Query after Connect        	       	          									     			                           								           ​     this);   		       	    while((rs = rs .next()) != 0){   printRecord (rS)};         
       }                                                                                 ResultSetMetaData md=resultset.getMetaData();  //Method for Printing record details        	       	                       									     			                           								           ​     this);   		       	    while ((rs = rs .next()) != 0){   printRecord (rS)};
       }                                                                                         ResultSet result_set=con.createStatement().executeQuery(query)  //Executing Query after Connect        	       	          									     			                           								           ​     this);   		       	    while((rs = rs .next()) != 0){   printRecord (rS)};
}                                                                                                void main() throws SQLException{       VanillaJDBCQueryHandler vjh=new  Vacant_Java J DBCHandler();          //Instantiating the object of this class        	       	                       									     			                           								           ​     DriverManager .getDriver ().loadLibary("com.mysql", "mysql");  	  con,url , userName and Password are set in connect method          	      }