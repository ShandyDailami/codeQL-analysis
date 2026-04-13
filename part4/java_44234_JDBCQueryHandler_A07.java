import java.sql.*; // Import necessary Java SQL classes and interfaces such as Connection, PreparedStatement etc...  
public class java_44234_JDBCQueryHandler_A07 {   
     public static void main(String[] args) 
         throws Exception{     
        String url = "jdbc:mysql://localhost/test";         
           // Specify the database name and port number here.      
              
        Properties info =  new Properties();  
        /* Create a properties object to set up connection parameters */   
            
            try {        
                Class.forName("com.mysql.cj.jdk.JdbcDriver");  // Load MySQL driver into the classpath by using "Class" objects in Java ...      jars are not included with java, but can be from local file system or URLs of online libraries     .       This is a JDBC Driver for Mysql
            } catch (Exception e) {          /* Catch exceptions as they occur */  // If we cannot load the driver then throw an exception.    Exception handling in Java         try-catch block which controls flow through application such that if any error occurs, control will not go to code after statement of "try" or it is caught and handled by corresponding catch clause
                e.printStackTrace();           // Prints out a message on the screen for exception debugging – This line must be here when an Exception Occurs       print stack trace          prints detailed information about what caused this run-time error such as: "Exception in thread" , then name of method, and finally actual Error Message
                System.exit(0);             // Exits the current Java Virtual Machine (JVM) with a specified status code...    It will end our application when an exception occurs         system exit is used to terminate threads which may or have not yet finished executing their task – If this call exists in any thread of execution then it must be at least once per every Thread object.
            }        /*Ending the try block */      // Ends a piece of code that could throw an Exception, and when such exception occurs ...    we use "try-catch" here to make sure our application does not terminate abruptly in case if there is any error with JDBC operations – Try/ catch blocks are used for handling the exceptions within method.
             /* End of try block */      //Ending a piece code that could throw an Exception and when such exception occurs, it will be handled by corresponding "catch" clause ...   Afterwards we exit program using system's built-in methods – This is how JVM ends execution through normal programs (not exceptions)
         }           /* End of Main method */    // The main() function begins the Java application. At this point, if no exception has been thrown in try block then it means our code did not encounter any runtime errors and thus we can say that program is syntactically correct with respect to JDBC (Java Database Connectivity)