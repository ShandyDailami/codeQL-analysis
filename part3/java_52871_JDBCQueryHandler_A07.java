import java.sql.*;   // Import necessary classes for JDBC connections ect...   
public class java_52871_JDBCQueryHandler_A07 {     // Class declaration       
      public static void main(String[] args) throws SQLException{       // Main method to start the application          
          String url = "jdbc:mysql://localhost/test";  // Set your database URL, user and password here.   Use a driver manager ect...   
          String username="root",password="passw0rd";     //Your User credentials      ...       
             
          try {            
            Connection conn = DriverManager.getConnection(url ,username,password);  /* Get the connection */               
               PreparedStatement pstmt;  
                 
                   String query = "SELECT USER FROM Users WHERE ID=?" ;    // Your SQL Query here...    
                     
                    try {        ///Try block for Connection and Statement          
                          pstmt =  conn.prepareStatement(query);  /* Setup the statement */      
                               pstmt.setInt (1,23456 );   /**/      set parameter value          ...    //Your Value here...     ***/                 
                            /// Execute Update or Delete Query             ..            .               .........           /         ****              ***  } catch block to handle exceptions                     try-catch statement for handling the Exception                    pstmt.executeUpdate();   /**/                /* End of code */                                                                // Catch Block ends here                      if statements, loops ect...    
                  });      throw conn;    ///Throws SQLException and Handles it within a Try..Catch block  } catch (SQLExcception se) { println("Database operation failed");   prints the caught exception.        }}*/}}}}}         // End of Class with All Code inside          .            *