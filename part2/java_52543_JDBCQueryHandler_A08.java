import javax.sql.DataSource;   // Import Data Source Interface and its implementations e.g., MySQLDataSource, OracleDataSource...etc    
       import java.sql.*;    //Import Statement ,PreparedStatement & CallableStatement interfaces ... etc     
         
public class java_52543_JDBCQueryHandler_A08 { 
	 private static final String URL = "your_dburl";   // your db url here i,e jdbc:mysql://localhost/test or similar for MySQL   
	    private static final String USERNAME="username";     //Your username Here       
        	private static final String PASSWORD  ="password ";     		// Your Password HERE  (not recommended to hard code passwords in the program, use environment variables)  		      
	        DataSource dataSource;   			           	   	     									         	 
              								              public java_52543_JDBCQueryHandler_A08() {     //constructor for initializing your Datasource.     	               						                 
        try{                     
        	//Create a pooled datasource object                   System.out.println("Connecting to database");  		                                                                          			 									         	 	       	     	    }catch(Exception ex){System.out.println (ex);}    //your exception handling code here for connecting DB    		}        private void closeConnection() { try{ if(!dataSource) return; Connection conn = dataSource .getConnection();  		
        	//Statement stmt=conn.createStatement()) ;  }catch(Exception ex){System.out.println (ex);}    //your exception handling code here for closing DB connection    		}        public void executeQuery() { try{ if(!dataSource) return; Connection conn = dataSource .getConnection();  		
        	// PreparedStatement pstmt=conn.prepareStatement("Your SQL Query")) ; }catch(Exception ex){System.out.println (ex);}    //your exception handling code here for executing query    		}  public static void main() { JDBCQueryHandler jdbchandler = new  
        	//JDBCQueryHandler();                                                      System..executequery;}}                   		             									         	 	     	    } catch (Exception ex)                   //your exception handling code here for program execution    		}  private DataSource initializeDataSources() { return dataSource;}    });       			     	       
}