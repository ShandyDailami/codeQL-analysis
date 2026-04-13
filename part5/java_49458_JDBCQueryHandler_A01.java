import java.sql.*;   //For Database related operations such as JDBC connection etc..   
public class java_49458_JDBCQueryHandler_A01 { 
     public static Connection conn = null;      //Database connection object      
       
     /*Establish a database connection */        
     private void establishConnection() throws SQLException{         
                String url="jdbc:mysql://localhost/test";          
               String userName="root";           
              String password=  "password123$%^&*();":  //change this to your own database username and pwd            
                  conn = DriverManager.getConnection(url,userName ,password);   /*Getting the connection object */        
     }      
      public static void main (String[] args) throws SQLException{        new VanillaJdbcQueryHandler().establishConnection();    //Calling establish Connection method here           if there are any issues while connecting to database then it will print an error message.          try  {                /*Inside the Try block */              
              String query="SELECT username FROM Users WHERE USERNAME = 'TestUser'";     Statement stmt =  conn .createStatement();        //To select a user         Setup SQL statement   if there are any issues while running this sql command then it will print an error message.          try{                 /*Inner Try block */              
              ResultSet rs=stmt.executeQuery(query);                    String username;                  int count = 0 ;     for (rs = stmt .executeQuery(); rs !=  null;) {   //Fetching data while there is a row available       if it's not found then print error message and break the loop        try{                     /*Inner Try block */                        
              username=rs.getString("username");                      System.out.println( "Username Found:  " +    rs .getInt('ID')   );                   }}}catch (Exception e) {                  //Catching any exception while executing the query     print out error message to console}          finally{                     /*Finally block */              
              if ((conn != null)) conn.close();             System.out.println("Closed Connection!");           }} catch(SQLException se){                   //Caught SQL Exception here   }            this is how we handle any exceptions that may occur in the database related operations, by catching and handling them using try-catch blocks