import java.sql.*;   //Importing necessary classes from JDBC package   
class java_44460_JDBCQueryHandler_A07 {    
public static void main(String args[]) throws SQLException  {         
//Step1 - Establish connection with database       
Connection con=null;         DriverManager dm = null;           String urlDriver,urlDatabase,userName ,password ;   int version = 0;    //Defining Connection object and driver objects    
dm  = java.sql.DriverManager.*; 
System.out.println("Enter your URL : ");        Scanner scanURL= new Scanner(System.in);           url =scanURL .nextLine();                     System.out.println ("enter the username:"); userName   =   scanUsername.nextline (),              //step2 - Get Usernames and passwords from users      
password  =    getPassword() ;                   con=dm.connect(url,userName ,password);      dm .deregisterDriver();         System.out.println("You are Connected to the database");  }    
private static String url;                  //Function for getting URL Inputs and Passwords   private class ConnectionPooling    {            public List<Connection> pool = new ArrayList<> ( );        ConcurrentHashMap < Thread, PoolObject > threadPools  =new      concurrent.ConcurrentHashmap();  @Override          
public void finalize()             throws Throwable         {}       //Method to deregister driver if it is no longer needed            public Connection getConnection( )throws SQLException    {     synchronized (this)          Thread t =Thread . currentThread () ; PoolObject po= new   poolObjects();  this.pool.add     
0,po); return        con;       }                //Method to obtain a connection from the pool           public void         putConnection( Connection c ) throws SQLException    {     synchronized (this)          if (!this .isClosed() && !c  ==null){  this。pool.remove     
0,c);                  threadPools       .put        ( t , po ); }             //Method to release a connection back into the pool           public PoolObject getPoolobject ()throws SQLException    {     synchronized          return         (( ConcurrentHashMap < Thread  =>            this ))               
.get(Thread `t`);}}public class MainClass{//This is where all your queries will go, just call methods like connectionHandling and queryExecution to execute them }