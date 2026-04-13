import java.sql.*;  // Import Statements, ResultSet and SQLException classes  
public class java_52241_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{       
         String url = "jdbc:mysql://localhost/test";      
          Connection conn=null;     
           try  // Try block for the connection.           
             {  
                 Class.forName("com.mysql.cj.jdbc.Driver");    /*Loads MySQL Driver*/        
                  System.out.println("\nConnecting to database...\n");       
                   conn = DriverManager.getConnection(url,"user","password" );      // Get Connection  	      		 	   
                 }          catch (ClassNotFoundException e) {               /*Handles Exception */            	       			   	 									     System.out.println("Driver not found, Please check the driver");}                     finally{conn=null;}              return;                      if( conn !=  null )   // Closing connection     
                 try 
                  {                   String sql ="SELECT * FROM Users";          		         	      			    ResultSet rs =     conn.createStatement().executeQuery (sql);               while (rs.next())            System.out.println("\nReading from database: ");              // Read Data                     }catch(SQLException se) {se.printStackTrace();} finally{conn=null;}      
    }}  /*End of Main*/                                          		  			     	     if(!stmt_selected){System.err         .println("Can't select a record from the database.");                 stmt = conn.createStatement( );                    } catch (SQLException e) {e.printStackTrace();}       finally{if (!conn.isClosed() )
        try   // Closing connection  if not closed already            				    		 Connection con=null;                     }}catch   			     	           (* SQLExceptiion se){se.printexception("Error in closing the database connection");}finally{if(!connections_list .isEmpty()) { for (Connection conn : connectionsList)