import javax.sql.DataSource; //1, Include the required Data source implementation such as HikariCP (Oracle), C3P0(MySQL) etc..   
public class java_46442_JDBCQueryHandler_A03 {    
      private static final String URL = "jdbc:mysql://localhost/test"; 
   /*2. Replace 'user' with your database username, and replace password as per requirement*/      
      private static final String USERNAME="root";    //Database Username        
      private static final String PASSWORD="@SQL#R4v3$t1nGs!";  /*Replace it by the actual user's Password */  
     DataSource dataSource = null ;      
// Load database driver       
public java_46442_JDBCQueryHandler_A03() {         
    try {              // load MySQL Driver           
           Class.forName("com.mysql.cj.jdbc.Driver");               }                catch (ClassNotFoundException e) {}  
         /*3, Initialize the connection pool */                  dataSource = new com.mysql.cj.jdbc.DataSource();        //Initiallize Connection Pooling                    if(null ==dataSource){             Logger logger=LoggerFactory.getLogger("JDBCExample");               logInfoOrErrorMessageForDbOperation (logger, "Creating Data Source", e);           }  
         /*4 Replace the above URL and USERNAME with your Database Details */       dataSource .setDataSource(URL ,USERNAME  PASSWORD );     //Set database connection details                    if(!dataSource.getConnection().isValid(2)){                     Logger logger=LoggerFactory.getLogger("JDBCExample");               logInfoOrErrorMessageForDbOperation (logger, "Invalid Connection", e);           }         
    }}  /*5*/       public void executeQuery() {     try{              // Executing a SQL Query                    if(null !=  dataSource){                   Statement stmt = null;                           Class.forName("com.mysql.cj.jdbc.Driver");                         Connection conn = 	dataSource .getConnection();                       String sql="select * from Users";                      PreparedStatement pstmt  =conn.prepareStatement(sql);                  ResultSet rs  = 	pstmt.executeQuery() ;                   while (rs.next()) {                        System.out.println("Name : " + rs.getString("name"));                    }                       conn .close();                          } catch  ......