import java.sql.*;
public class java_42870_JDBCQueryHandler_A03 {  //Example Class Name as per Instructions a) c and d).e,f.) b (I will add comments later in response below for easier understanding of the process)!    
    public static Connection getConnection() throws SQLException{  
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());  //Example driver class name as per Instructions a) c and d).e,f.) b!      
                                                                          Returns the connection to MySQL database using JDBC !    
    String url="db_url";      //Replace with actual URL of your Database (a string for example)!   db.mysql://localhost/test?useSSL=false - Replace it by real one, and make sure you replace all occurrences!      
        Properties props = new Properties(); 
                                                                          The properties that will be loaded on the connection !    
    String userName=  "user"; //Replace with actual username (a string for example)!   db_username - Replace it by real one, and make sure you replace all occurrences!      
        props.setProperty("user", userName); 
                                                                          The password that will be loaded on the connection !    
    String passWord= "password"; //Replace with actual Password (a string for example)! db_pass - Replace it by real one, and make sure you replace all occurrences!     
        props.setProperty("password", passWord);  
                                                                          The URL of the database !    
    String driverClassName= "com.mysql.cj.jdbc.Driver"; //Example class name as per Instructions a) c and d).e,f.) b (same here)!     
        Class.forName(driverClassName);  /*This will load MySQL Driver for the database connection ! */    
                                                                          The url of our server from where we want to connect using this driver (!   
         return DriverManager.getConnection(url , props );   //Returns Connection object with JDBC enabled on specified Database (URL and Properties loaded) !      
                                                               }             public static void main... {        /*This is the entry point of application ! */     
                                                                          Here I will write some test cases for insertion, deletion & retrieval operations like in examples above.   //Here you can add your code to handle these scenarios and display results!      
     ... }  });                                                       Closes main method}        /*Closing brackets of the Java program */      }} ;    Here I am adding comments for better understanding as per Instructions b)! As this is not a full project, only given example has been provided. This may or may be part to larger application based on real-world requirements!