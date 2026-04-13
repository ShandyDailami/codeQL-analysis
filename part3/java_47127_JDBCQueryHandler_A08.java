import java.sql.*; // We need Java's built-in 'Connection', Statement, ResultSet classes here...for our SQL operations (Create connection) and handle them in a JDBC way(with try with resources - best practice for the resource cleanup part.)  
public class java_47127_JDBCQueryHandler_A08 {  //Define your Class name as per Java naming convention.    
    public static void main(String[] args){     
        String url = "jdbc:mysql://localhost/testdb";       /*URL of the database you want to connect*/        
        String username="root", password=  "";  // Your MySQL user name and its empty for security reasons.         
                 Connection connection;              /** JDBC maintains a pooling feature, that's why we need this 'connection'. */          
                try {       /*try-catch block here is used to handle any exceptions which might occur while connecting with the database*/ 
                    //Step1: Load Driver         **It will load MySQL driver for our Java program.**    using ClassLoader instance     ***Load it at runtime***     
                     connection =DriverManager.getConnection(url, username , password);       /*Create Connection */          
                      System.out.println("Connected to DB");  //Confirm the successful creation of a new database session with driver manager                .*/            }) {             /** 'try' block contains our SQL operations and where they are executed (insert data into table, select etc.)**/    } catch(Exception e){     /*If there is any exception at this point then print it out here */          System.out.println("Connection Failed! Check output console for Detail");     
                //e.printStackTrace();  It will give you an idea of what went wrong in case if the connection fails due to some reason such as network failure, driver not loaded etc..   }                      }}`