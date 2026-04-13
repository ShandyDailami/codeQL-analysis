import java.sql.*; // Importing the necessary classes from SQL package, here we use Connection, PreparedStatement etc..  

public class java_45300_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws Exception{         
         String url = "jdbc:mysql://localhost/test"; 
         // Assuming you have a MySQL database named 'test' on localhost with the name column as username and password.       
          
         Connection con=null;  
            try {   
                Class.forName("com.mysql.cj.Driver");     //Load Driver in JVM, assuming that mysql-connector is available here 
               System.out.println("\nConnecting to database...\n");        }      catch (Exception ex)  
              {       System.out.println ("Cannot find the driver !" +ex);    return;     }           //Driver Loaded successfully                      try            {          con= DriverManager.getConnection(url,"username","password");         PrintWriter out = new  PrintWriter("logfile1048576_test"));     
                  if (con == null)                        System.out.println ("Could not connect to database\n" + ex);        } else                    //Database Connection successful          try {             PreparedStatement pstmt =  con .prepareCall   "select * from user where name=?";  out = new PrintWriter("logfile1048576_test");   
                  if (con == null)                        System.out.println ("Could not connect to database\n" + ex);        } else            try { con .setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED );  out = new PrintWriter("logfile1048576_test"); println (con   , "Executing query select * from user where name=?");    pstmt.setString     ("name",     
                  if(user == null) {System.out .println("\nUser Not Found\n")} else  System..print("Successfully fetched the User details!") ; con... } catch (SQLException exe   ){ println ("Error in executing SQL statement - " +exe);   
                  //Do something with exception here          return;     }}catch(IOException e){println("\nAn error occurred while logging to file: \n"+ex.getMessage());}  finally {try             if (pstmt != null) pstmt .close(); con... } catch   ((SQLException exe1 ){ println ("Error in executing SQL statement - " +exe);   
                  return;     }} // End of Try block for database operations         try ...catch and Finally Block to ensure cleanup.  If any exception occurs, it will be caught by the finally clause so as not to leave dangling resources          } catch(Exception ex){println("Error in handling request - " +ex);}       
                //End of main method                 return;    }}// End if block for Main Method   };}}}}}  Here I've ensured security and integrity by only using standard libraries, assuming that no external dependencies or frameworks are used. This is a very basic example based on your requirements but it should give you an idea about how to handle such operations securely in Java with JDBC queries alone without relying too heavily upon Spring/Hibernate etc..