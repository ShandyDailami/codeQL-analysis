import java.sql.*;    // Import the necessary classes  
public class java_53500_JDBCQueryHandler_A08 {     // Main Class name should be in camel case as per Java naming conventions ie, CamelCase is used here     
        public static void main(String[] args)  {           
                Connection conn = null;                       // Create connection to DB            
                        try{                     
                                String url="jdbc:sqlite:/Users/user/.db";              /* You can change this path according your needs */        
                        	conn  = DriverManager.getConnection(url);   
                                                          
			// If you want, here we create table for example               
                                                if ( conn != null ) {                      
                                            System.out.println("Connected to SQLite!");     // This will print the successful connection message                
                                             Statement stmt = conn.createStatement();  /* Create a statement */  
                             try{                                                        /**/                                                                         
                                         String sql;                          /*!< Your delete operation here **/             
                                        PreparedStatement pstmt =  null ;    \(This is for your insert,update and select operations\)             // Declare the variable      stmt = conn.createStatement();  /* Create a statement */  
                                try {                            /**/                                               sql="INSERT INTO COMPANY (ID,NAME,LOCATION) VALUES(''102'', ''John'' , ''New York'')";             // This is your SQL operation                          stmt.executeUpdate(sql);                   /* Execute the statement */
                                     } catch (SQLException se){        /**/                                               sql="INSERT INTO COMPANY (ID,NAME,LOCATION) VALUES('103','Mike', 'London')";              // This is your SQL operation                          stmt.executeUpdate(sql);                   /* Execute the statement */
                                         } catch (Exception e){                         /**/                                               sql="INSERT INTO COMPANY (ID,NAME,LOCATION) VALUES('104','Eve', 'Vienna')";              // This is your SQL operation                          stmt.executeUpdate(sql);                   /* Execute the statement */
                                     }  finally {                       /**/                                               conn.close();                  System.out.println("Closed connection");          }} catch (SQLException e){                SQLEXCEPTION_HANDLER}   // Catch exception if any                          try{ stmt =conn .createStatement() ;     /* Create a statement */ 
                         }catch( SQLiteException se ) {                      SEQUELITEEXCPTION_HANDLER;                    System.out.println("Error Occurred!");                  // This will print the error message                   try{ stmt = conn .createStatement() ;     /* Create a statement */ 
                         }finally {                                        FINALLY                                                     if (conn != null) {                           Close connections in finally block                      System.out.println("Closed connection"); }} catch(Exception e){            EXCEPTION_HANDLER}}    // Catch exception   /* End of Main method */
        }  void SQLEXCEPTION_HANDLER(){     /*!< Your SQL Exception Handler here **/             System.out.println("An error has occurred.");              e.printStackTrace();                  }} EXCEPTION_HANDLER() { /**/                                  /* This is for catching the exception */