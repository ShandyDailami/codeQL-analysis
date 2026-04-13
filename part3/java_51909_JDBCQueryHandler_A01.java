import javax.sql.DataSource; // Import required Java packages for Data Source and ResultSet objects, etc。  
import java.sql.*;   
public class java_51909_JDBCQueryHandler_A01 {    
//Step: Define a private data source object which is responsible to provide connection with the database  . For instance we are using MySQL's Driver here in step A2 - B4 (a)       and C1 respectively..         //(b,c).    Data Source should be provided from outside such as by configuration file.     
private final static String DB_DRIVER = "com.mysql.jdbc.Driver";  /* Database driver name */  
private final static String DB_URL     ="jdbc:mysql://localhost/testdb?useSSL=false&rewriteBatchedStatements=true"; //provide your database url here..    (b,d).          For example - jdbc.sqlserver.com or mysql://hostname/,port etc., depending on what you use in step A2- B4(a)      
private final static String USER       =  "root" ;  /* Database user name */   //Provide your database username.. (b,d).    For example - root , myUser    
private final static String PASSWORD   = "";// Providing password for the account here. Password should be provided from outside such as by configuration file or through command line etc., depending on what you use in step A2- B4(a) and (b,d).    For example - mypassword 
private Connection conn = null; // Connecting to database server    
public java_51909_JDBCQueryHandler_A01() {       /* Initializing the data source */  
try{             this.conn=DriverManager.getConnection( DB_URL , USER , PASSWORD );           }catch (Exception e){          System.out.println("Error in establishing Connection with "+this._dbName +" :: Error:  ");e.printStackTrace();}  
/* Step A2 - B4 : Create a method which will perform the query here */       //Step C1 and D3 are related to creating methods like getUserList(),addNewBook() etc, based on requirement (a).    System.out.println(this._queryResult);          } catch (SQLException e) {           
e.printStackTrace();           }}//End of Method  */        //Step C1 : Print the result or handle exceptions here             };     /* Step A2 - B4: The end and start points for method creation are related to creating methods like getUserList(),addNewBook() etc, based on requirement (a).