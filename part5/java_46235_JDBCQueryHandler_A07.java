public class java_46235_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws SQLException {
        // Step1 - Establish the connection to database  
		// Note that this is just an example and should be replaced by your actual Database Details.
	    String url = "jdbc:mysql://localhost/db_name"; 
    	String username="username ";   		
     	String password= 	"password";       			       // Don't forget to replace with real values from the database	  	 	     
         Connection conn =  DriverManager.getConnection(url, username , password);         									          															            	    }  catch (SQLException ex) { System.out.println("Error connecting: " +ex );}        finally{ if(conn != null && conn.isClosed() == false){conn.close();}}
    	        			   		  	 	        // Step2 - Prepare a statement for data retrieval 									     	    } catch (SQLException ex) { System.out.println("Error in query: " +ex );}           finally{ if(stmt != null && stmt.isClosed() == false){try {conn.close();}}catch (SQLException se){System.out.println ("Can't close connection - Database Unavailable"+se); }}}}