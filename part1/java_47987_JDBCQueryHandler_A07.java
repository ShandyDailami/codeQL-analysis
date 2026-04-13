import java.sql.*;
// import necessary libraries here if needed, e.g., javax.swing.* for GUI apps etc... 
public class java_47987_JDBCQueryHandler_A07 {   //class name according to Java naming convention (Camel case) should be the same as file or package names due to encapsulation concept in OOPs concepts   
    
// private fields that would hold your database's details, these values could come from a configuration property / secure vault etc...  for instance:   String dbUrl = "jdbc..."; // make sure you have the correct JDBC driver on classpath. You can load it at runtime by using java properties or environment variables
    private static final String USERNAME="user";//same as your username in database user should be same for both  and password also need to be kept secret...and ideally these credentials are stored securely (not hardcoded, use a vault/secret management tool etc...)   //TODO: implement proper secrets storage
    private static final String PASSWORD="password";//same as your username in database user should have same password and also need to be kept secret...and ideally these credentials are stored securely (not hardcoded, use a vault/secret management tool etc...)   //TODO: implement proper secrets storage
    private Connection connection = null;  // declaring the instance of jdbc.Connection in static mode can prevent new instances from being created and thus limiting memory leakage on JVM lifecycle... (static keyword is used here to avoid instantiating a class)    
        
public java_47987_JDBCQueryHandler_A07() {   }    /*Constructor will be called when object of this class are made*/  //constructor with empty body for the sake if it’s needed. But usually, you don't have one and constructor is used to initialize instances variables in a correct manner... (also here using 'static keyword)
    
public void openConnection() {   /*This method will call when we want our connection or database*/  //method for opening the Connection with Database by making it static so no need of object creation   
         try{      
        Class.forName("com.mysql.cj.jdbc.Driver");//loads mysql driver    
            this.connection = DriverManager.getConnection(dbUrl, USERNAME , PASSWORD); // creating Connection by passing database URL and username/password to get connection object...   (static keyword is used here as we are using static fields)  } catch SQLException e { printStackTrace(); }}   
     public void closeconnection() throws Exception{ /*This method will call when the work done in openConnection(...) has been completed*/ //method for closing Connection with Database by making it a non-static... (making this instance aware of its connection)  try { if(this.connection != null){