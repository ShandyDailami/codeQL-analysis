import java.sql.*;   // Import the required classes   
public class java_47955_JDBCQueryHandler_A03 {    
// Step1: Create a Connection to your database using DriverManager     
static final String DB_URL = "jdbc:mysql://localhost:3306/mydb"; 
static final String USERNAME="root";   // Your username   
static final String PASSWORD="password";//Your password    
public Connection connection;      
Connection connectToDB() {     
connection = null;         
try{       
Class.forName("com.mysql.cj.jdk.Driver");  /* Step3: Add the JDK Driver for MySQL to your classpath */   //Step2 : Create an instance of Connection using driver manager   
 connection=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);/* Use username and password provided*/     
System.out.println("Connected Successfully!");  }         catch (Exception e) {e.printStackTrace();}     return null;   }}`