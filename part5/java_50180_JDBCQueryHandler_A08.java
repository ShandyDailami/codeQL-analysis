import java.sql.*;   // Importing necessary Java packages like Connection, Statement and ResultSet   
class java_50180_JDBCQueryHandler_A08 {    
public static void main(String[] args) throws SQLException{       
          String url = "jdbc:mysql://localhost/test";     
           String username="root";      
            String password="password";   //You should store the secret database credentials in a secure way. In real world application, never hard code your secrets directly! 
     Connection connection;    // Declaring new instance of Connector class which will allow to connect Database      .       
          Statement statement ;       //Declare and initialize object for our SQL queries  
           System.out.println("Connecting database...");        
            try {                      //Try block, Here we are establishing the connection with MySQL server  using driver "com.mysql.jdbc.Driver"    .        Connection created as well     
             Class.forName ("org.mysql.cj.driver");       System.out.println("Connected database successfully...");               
              connection = DriverManager.getConnection(url, username , password );   //Getting a connection object and calling openconnection method of the connector class     .        statement =  Connection.createStatement();    }  catch (ClassNotFoundException e) {         System.out.println("Driver not found");     
            e.printStackTrace() ;                  return;       }}             finally{ //Auto close resources when done with them          connection != null &&connection.closeable ?   connection .close () : ""; }              if(statement!=  null) { statement	.close();  }}}`// End of the program