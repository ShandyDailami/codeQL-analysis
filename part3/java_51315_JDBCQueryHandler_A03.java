import java.sql.*;

public class java_51315_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost/test"; // replace with your db url and name
    private static final String USERNAME = "root";   //replace root as per mysql server configuration 
    private static final String PASSWORD="password1234@#$%^&*()_+`~{}|[]\\;:,.<>?\"' ";// replace with your password if any on the MySQL Server and in this case is a dummy placeholder value for sake of demonstration
    
    public static void main(String args[]) { 
        try{  
            //Step1-Register Necessary JDBC Drivers. If not already registered then it can throw ClassNotFoundException at runtime which we will handle by wrapping the logic inside a Try/catch block to prevent our program from crashing due to unhandled exception caused in DriverManager class initialization  .
            //In this case, MySQL driver is used but other types of drivers should be handled too. The exact way depends on your specific use-case and configuration details for each DBMS provider like Oracle JDBC , H2 Database etc., by using respective providers's classes names (com.mysql.* in Java)
            Class.forName("com.mysql.cj.jdbc.Driver");  //MySQL Driver here, replace with your driver class name if different from MySQL Server default one provided above   .    "//" is used to prevent any syntax errors at compile time by marking it as a string (String) literal in Java source file
            
            Connection con=null;    
                try {  //try/catch block for connection establishment and handling exception gracefully.      
                    con = DriverManager.getConnection(URL, USERNAME ,PASSWORD);   //Replace with your DB URL Username & password if different from MySQL Server default one provided above    .      "//" is used to prevent any syntax errors at compile time by marking it as a string (String) literal in Java source file
                    System.out.println("Connection successful"); 
                     }catch(SQLException se){   //Catch and handle SQL Exception gracefully if exception occurs while getting connection from DriverManager     .       "//" is used to prevent any syntax errors at compile time by marking it as a string (String) literal in Java source file.     
                        System.out.println("Unable To Establish Connection");  se.printStackTrace();   //Print the exception stacktrace for debugging purpose     . "//" is used to prevent any syntax errors at compile time by marking it as a string (String) literal in Java source file   
                    }     
                if(con != null){            //if connection established then try/catch block will be there which includes all the operations on database.   . "//" is used to prevent any syntax errors at compile time by marking it as a string (String) literal in Java source file   
                    String query = "select * from employees where id=?";  //Here we are selecting data of employee with given ID which has A03_Injection risk. We will use parameterized queries to protect against this attack .  
                                                       try {                           
                                    PreparedStatement pstmt  = con.prepareCall(query);//step-2: prepare a callable statement for execution and handle exception gracefully     ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file   .    }catch block should contain the catch blocks related to your exceptions.
                                                                      // step -3 : Bind value using parameter index, column position etc., and then execute query via callable statement ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file .    }catch block should contain the catch blocks related to your exceptions.
                }}                 // step-5: close all resources which you have opened such as ResultSet , PreparedStatement and Connection objects here ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file .    }catch block should contain the catch blocks related to your exceptions.
              //step-6: close connection regardless of operation result such like commit or rollback if needed, etc., here ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file .    }catch block should contain the catch blocks related to your exceptions.
               //Finally statement that close all connections which are opened even after operation result check have been done or not, here ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file .    }catch block should contain the catch blocks related to your exceptions.
            System.out.println("End of program"); //Here we are ending our execution and cleaning up all resources before exit ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file .    }catch block should contain the catch blocks related to your exceptions which includes end resource cleanup.
        }}//Closing brace for entire program and its associated code here, this will ensure that all resources are closed properly when our main function finishes executing ." "/// is used prevent any syntax errors at compile time by marking it as string (String) literal in Java source file .    }catch block should contain the catch blocks related to your exceptions which includes end program cleanup.