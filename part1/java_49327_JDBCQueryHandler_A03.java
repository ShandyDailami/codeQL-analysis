import java.sql.*;   //for all database connectivity functionalities
//Spring's dependency injection feature: @Autowired, constructor-based and setter methods are used here for simplicity in the example code below..   
public class java_49327_JDBCQueryHandler_A03 {    
       private DriverManagerDataSource dataSource;  //data source bean created using Spring’s jars.  
        public void insertIntoDatabase(String sql){          
                try{             
                        Connection con = this.getConnection();              
                          PreparedStatement pstmt=con.prepareStatement (sql);                   
                         boolean b =pstmt .executeUpdate() ;                   if (!b) {                     System.out.println("Failed to execute insertion"); }  else    //if query successful then print success                      message                           System.out.print(“Inserted successfully” );   con.close(); pstmt.close();                         
                } catch (SQLException e){                   this .logerror ("Error in SQL statement: " + sql,e);}            finally {                     if (!con == null) try{                    //if connection is not empty then close it                      con.close();   }catch(SQLError e1 ){}  }}
       private Connection getConnection(){    return this .dataSource .getConnection ( );}}      class SpringJDBCImpl implements ApplicationContextAware {     @Autowired             DataSource dataSource;                  //setting the instance of spring datasource.              public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{         
                try        this._dataSource=applicationContext .getBean("datasource");}}   – it's a Spring bean which you can use to get database connection     private static DataSource _dataSource;             //this is the data source instance created using spring’jar.    public Connection newConnection()throws SQLException{         
                if(_connectURL == null) throw new NullPointerException();      return DriverManager .getConnection (_connectURL,_userName ,_password );  }   static String _connectURL = "jdbc:mysql://localhost/testdb";static final String _userName="root", _password  =“root”;