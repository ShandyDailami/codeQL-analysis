import java.sql.*;   // Import necessary Java libraries (i.e., Statement and ResultSet)
public class java_48879_JDBCQueryHandler_A08 {  // Declare the program as a "JdbcExample" or similar name that describes what it does better -> e.g.: RetrieveData, HandleExceptions... etc .    
    public static void main(String[] args){  
        String url = <database_url>  ;// replace with your database URL  , ie: jdbc://localhost/sampleDB;user=root;password=secretPassword (you should not include the password in this, only for reference)    
         Connection conn =  null;    // Declare a connection object as NULL. We will use it later to establish our DB connections with DriverManager  
        Statement stmt =null ;      //Declaring statement and result set objects  we'll be using them throughout the program...      
           try {                    //Start of Try block, where all database operations happen    ....     .                  
             conn=DriverManager.getConnection(url,"root", "secretPassword");   /***** Establishing a connection to DB with Driver Manager  *********/     
               stmt =conn.createStatement();                          /* Create our Statement object */      
              String SQL_QUERY =  // Here's the query, e.g.: SELECT firstname FROM users WHERE age > 18;   ;    /***** Add your actual sql here  ***********/    
               ResultSet rs = stmt.executeQuery(SQL_QUERY);           /* Execute our SQL Query on DB */       
              while (rs.next()) {                                        // Processing each row returned by the query....          .   /***** Add your processing here  ***********/      }                 
               conn.close();                                             /* Close Connection after all operations are done...     ..    /** The connection is no longer needed */                    catch(SQLException se) {}                          try{ if (conn != null && stmt != null){   // This will attempt to make sure we're closing everything up here  .
                            conn.close();                                                       /* Close Connection and Statement objects, then release DB resources*/    }                 }}catch(SQLException se) {se.printStackTrace();}      return;                               catch (Throwable e){   // This will handle any exception that might happen ...     ..                             try{ if 
                            ((Connection) conn != null && stmt!=  null )conn.close() ;    /* Close Connection and Statement objects, then release DB resources */ }catch(SQLException se)};                     catch (Throwable e){e .printStackTrace();}            return;}   //This will be the end of our program