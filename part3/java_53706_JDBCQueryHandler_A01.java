import java.sql.*;  // We only need this for Java SQL classes (not a database library)
  
public class java_53706_JDBCQueryHandler_A01 {     
    private static final String DB_URL = "jdbc:mysql://localhost/test";    
    private static final String USERNAME ="root";      
    private static final String PASSWORD =  "password123456!";  // You should replace with your actual password          
  
      public Connection connect() {        return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);     }         
           
public void executeQuery (String query)    {         try{            
                                                  Connection connection = this .connect();                         
                Statement statement=connection.createStatement();               String selectData=query;          
              ResultSet resultset= 	statement.executeQuery(selectData);   while 		    	(resultset	.next()){                   System.out.println(" Accessing data through JDBC ");        }                      connection .close ( );      }} catch Exception e {         // Handle any SQLExceptions here          
e.printStackTrace();          }      
}