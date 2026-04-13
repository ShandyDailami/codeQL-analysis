import java.sql.*;   // Import necessary classes from the package "java.sql"   

public class java_44751_JDBCQueryHandler_A03 {
     private Connection conn;      // Declare a connection object of type 'Connection' to hold database connections and results in Java Database Connectivity (JDBC) 
                                   
                                   /* Establish SQL Server, MySQL or any other RDBMS here*/  
    public java_44751_JDBCQueryHandler_A03() {    
        String url = "jdbc:mysql://localhost/testdb"; // Specify database details like URL and DB name which will be in your local machine 
                                                       // Replace 'url', username, password etc with actual values.      
          try{             /* Try block to catch the exceptions */   
            conn = DriverManager.getConnection(url,"user","password");  
           }catch (SQLException e){               /** Catch exception if any occurs during connection*/ 
                System.out.println("Error in establishing Connection: "+e);        // Print error message on console to show the problematic part of your code   
            }      /* End catch block */  
       }             /*End constructor method JDBCQueryHandler() and its end brace '}'*/ 
    
                                                   /*********Injection Protection Starts Here***//       
                             // This is a very basic example, you might want to use PreparedStatements or other methods for injection protection.     
                            public void insertIntoTable(String name){             /* Method definition starts here */   
                              String query = "INSERT INTO users (name) VALUES (?);";   /** SQL statement **/ 
                               try {                                              // Begin a transaction block          
                                  PreparedStatement pstmt =  conn.prepareStatement(query );     
                                   int affectedRows=pstmt.executeUpdate();                    /*Execute update operation */        
                                    if(affectedRows > 0)                                         // Check whether any data is inserted or not 
                                      System.out.println("Inserted " + affectedRows+" rows");    /** Print the number of row/s updated **/  
                                  }catch (SQLException e){                                     /* Catch exception in case there're SQL errors */       
                                    // handle error here, this is just a placeholder         System.out.println("Error: " +e); 
                                           });                                                                    /** End catch block for the above try-catch **/     }   ;;// end method definition and its start brace '{'                         
                            /*End of JDBCQueryHandler class */                             // Note : Do not forget to close your resources in finally or use a statement based approach.  Replace conn, stmt with final if necessary after usage             )};         };    } ;;// end main method and its start brace '{'