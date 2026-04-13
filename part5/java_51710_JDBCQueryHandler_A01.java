import java.sql.*; // Import required Java libraries/components from JDBC package (ResultSet etc)   
        
public class java_51710_JDBCQueryHandler_A01 {    
        public static void main(String[] args){         
            try{            
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password"); // Replace with your database connection details          
              /*  This will create a statement object and call it 'st' */  
               Statement st=conn.createStatement();     
            }catch(Exception e){         
                System.out.println("Error in connecting to MySQL Database : "+e);       // Error Handling if database connection fails        };  },// End of Try-Catch block    Connection closed, statement and results are no longer valid              st=conn.createStatement();   }catch(SQLException se){         
            System.out.println("Error in executing SQL Query: "+se);       // Error Handling if there is any error while running the query      };  });// End of main method    private static ResultSet executeQueryForResultSets (String sql, Connection conn) throws Exception {     try{        
            Statement st=conn.createStatement();             System.out.println("Executing SQL Query: "+sql);        // Executes the passed query          }catch(Exception e){      throw new DatabaseAccessFailedError ("An error occurred while executing a database operation",e );  };     return null;   },// End of executeQueryForResultSets method    private static void closeConnection (Statement st, Connection conn) throws Exception {       try{         // This will be called when we are done with the connection and statement          
            if(st !=null &&conn.isClosed()){             System.out.println("Disconnecting from MySQL Database");          }else  throw new InvalidConnectionError ("The passed Connection or Statement is not valid", st);   };     },// End of close method    executeQueryForResultSets (String sql, Connection conn) throws Exception {       try{         // Here we call our utility methods to retrieve the results          
            return getExecuteAndReturnResults(sql,"SELECT * FROM myTable WHERE id = "+id);   };     },// End of main method    });  }.close(); }} catch (Exception e){ System . out . println (" Error in closing connection :" +e );}}; // If an exception is caught, this will be executed here