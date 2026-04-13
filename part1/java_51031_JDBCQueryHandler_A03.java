import java.sql.*;  // Import necessary SQL classes here  
    
public class java_51031_JDBCQueryHandler_A03 {     
    private static final String url = "jdbc:mysql://localhost/test";        
    private static final String userName="root";         
    private static final String password=  "password";       
          
// Establish a connection to the database 
public Connection getConnection() throws SQLException {    
       return DriverManager.getConnection(url,userName,password);   }     
              
 public ResultSet executeQueryHandler (String query)throws SQLException{    //Method for executing Query and returning Results             
        Statement stmt = null;           Connection conn=null;            
         try {                          
            conn =  getConnection();                if(conn==null){ System.out.println("Failed to make connection!"); }               else   {                     
                                                       // Prepare the statement   
                    stmt  = conn.createStatement();     return  stmt .executeQuery (query );      }}                   catch (Exception ex)                  {                        printSQLexception(ex, "Something went wrong with MyDB");}         finally{conn = null;}   }             
       public void executeUpdateHandler(String update){                 //Method for executing Update statements     if conn is not open then it will be opened.        try  {} catch (Exception ex) {printSQLexception(ex, "Couldnt perform operation due to: ");}          finally{conn = null;} }                  
                private void printSQLexception(Exception ex, String msg){   //Method for printing SQL exception with message       System .out .println ("ERROR :" +msg+ "\n"  +ex);  }}    });     this.executeUpdateHandler (“UPDATE......");}};       `});      }