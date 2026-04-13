import javax.sql.DataSource;   // Database access support (DriverManager) via SQL protocol   
        import java.sql.*;     // for database operations ie., executeQuery, update etc..     
public class java_50245_SessionManager_A03 {           
       private DataSource dataSource = null ; 
             public void setDataSource(DataSource ds ){  
              this .dataSource =  ds;  
                           }        
        /** Executes a query that returns all the rows in an ResultSet resulting from executing sql. */    // executeQuery() method of JDBC    
                private List selectRowFromDatabase(){  // get resultset      list<User> userList = new ArrayList<>();      
                  String SQLqueryString="SELECT USER_ID,USERNAME FROM User";//SQL query string to be executed   if(conn==null)          return null;     Connection conn  = dataSource.getConnection() ;  ResultSet rs = 	        	    // Executing the sql statement    executeQuery (rs,"select * from user")
                  try {                    while ((rs = rs.next()) ){ User users=new   User();users .setUserId(rs.getString("USER_ID"));         		           	// add to list      } conn.close() ; return 	userList;}       catch (SQLException se)    {} // handle any SQL exceptions here    
                public static void main(){        new SessionFactory().selectRowFromDatabase();   }}               private User user = null:         if(conn==null )         	return;      Connection conn  = dataSource.getConnection() ;  PreparedStatement pstmt = 	      	   	// create a preparedstatement to avoid SQL injection attacks   		    
                try {            String in_userid="123";pstmt =   coonectionstring+in_UserId +"( @nested);        // execute the query        	pstmt.executeUpdate();  conn .close() ; }catch(SQLException se ) {}// handle any SQL exceptions here