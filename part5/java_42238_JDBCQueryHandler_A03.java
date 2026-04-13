import java.sql.*;   // Import required classes from the database package (i.e., SQL, ResultSet)   
    
public class java_42238_JDBCQueryHandler_A03 {     
        public static void main(String[] args){         
            String url = "jdbc:mysql://localhost/test";      
            
            try{              // Try block for establishing a connection with the database.  
                Connection conn=DriverManager.getConnection(url,"root","password");    
                
               System.out.println("Connected to MySQL!");     
                    
                             }catch (SQLException e) {    // Catch blocks if there's any issue like wrong URL, invalid username/ password etc  .  
                   System.out.println(e.getMessage());    
                };              try{               // Try block for creating a statement which is used to execute SQL queries         
                    Statement stmt=conn.createStatement();      
                     String sql ="SELECT * FROM employees";       
                      ResultSet rs;         // Declare and initialize the result set  .  
                      
                try {                  /* The Try block for executing a query */   
                   rs=stmt.executeQuery(sql);          PrintResultSet(rs) ;           }catch (SQLException e){             System.out.println("Error in Execution Query: "+e );            };   // Catch the exception if there're any errors while executing .  End of try block   
                                                       catch {System.err.printf ("An error occured");}         }      finally{                /* Finally Block to ensure that resource like connection, statement or result set is closed even in case of exceptions */               System.out.println("Closing Connection and Statement.");conn.close();stmt.close();          }} ;