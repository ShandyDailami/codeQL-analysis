import java.sql.*;   // For ResultSet, Statement & PreparedStatement interfaces   
implicit import org.apache.commons.dbcp2.* ;     /* Database connection pool */            
/* Create our own implementation of SessionFactory and ConnectionManager for managing sessions without actually connecting to any database  */        
public class java_52716_SessionManager_A03 {  
private static BasicDataSource dataSource;      // Our custom Data Source (Database connection池)   
static final String DB_URL = "jdbc:mysql://localhost/test";        /* Database URL, change as needed.*/    
static final String USERNAME="root";       /** Your MySQL username */ 
private static ThreadLocal<Session> sessionLocator=  new ThreadLocal<>();      // Our thread local Session container   
/* Creating the Data Source (Database connection pool) using Apache Commons DBCP2 library.*/    
public void start() {   dataSource=new BasicDataSource();       /* Set Pooled Connection Configurations */ 
dataSource.setDriverClassName("com.mysql.jdbc.Driver");      // MySQL JDBC Driver Class Name    , change as needed, you can use other DB drivers also    
System.out.println( dataSource);                         //Prints the available properties of Data Source  
DataSource dataSourcest=dataSource;                      /* Getting Database Connection */  try{                Session session =null ;              String queryStr1  ="CREATE DATABASE IF NOT EXISTS `test`";                 Statement stmt   =ds.getConnection().createStatement();         //Create database         
stmt .executeUpdate(queryStr1);                        return; }catch (Exception e) {throw new ExceptionInInitializerError("Failed to create Database");}   catchSQLExeception{ throw  SQLexeption;}    try{}     /* Getting Connection */      Session sess =  dataSourcest.getConnection().createSession();       
sessionLocator .set(sess);                             //Setting session in threadLocal way          }finally {}}            finally {}                 if (null != ds)  closeDataSource() ;             return;   try{                String queryStr2  ="SELECT COUNT (* ) FROM `test` WHERE USERNAME ='root';";                  Statement stmt   =ds.getConnection().createStatement();         // Select count of root user from database         
ResultSet rs=stmt .executeQuery(queryStr1);               if (rs !=  null) { throw new ExceptionInInitializerError("Root User Exists in the Database");} }catchSQLExeception{throw  SQLexeption;}    catch{}     try {} return; }} //closing connection and releasing resources */  
public Session getCurrentSession() throws HibernateException           /* Retrieves Current session from Thread Local container*/ {          if (sessionLocator.get() == null) start();         System .out  .println( "No current session available in this thread"); return ((BasicDomainSession )       sessionLoc locater . get()).detachCopy () ;   }
public void closeDataSource(){        //Closing the data source and releasing resources */    DataSourcest.close();     }}`  /* End of Custom Session Manager Example Program*/                  Closeable { @Override public synchronized final void close() throws SQLException{ if (ds != null) ds .close () ; }}}