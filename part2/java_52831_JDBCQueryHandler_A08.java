import java.sql.*;   // Import necessary classes from Java SQL package   
class java_52831_JDBCQueryHandler_A08 {    
 public static void main(String[] args) {       
  String url = "jdbc:mysql://localhost/testdb";     
         
 try (Connection con  = DriverManager.getConnection("url", user, pass);           // Step1 : Get a Connection to the database  
       Statement stmt =  con.createStatement())                                   // Steps2 & 3 and prepare statements for your queries here         ) {             
     String sql;            
     
    /* Sample query */                     
        sql = "SELECT * FROM my_table WHERE id < (select max(id) from other_tables);";  
                    stmt.executeUpdate(sql)) ;                                          // Step4: execute the queries, do not forget to close statements after operations 
          } catch (SQLException e){                                                       /* Catching SQL Exceptions */                    
             System.out.println("Error in Connection");                            
              e.printStackTrace();                                            
           }                           
         });                                                                        // Step5: Close connection at the end