import java.sql.*; // Import the necessary Java database classes: ResultSet, PreparedStatement, Connection etc...  
      
public class java_53358_JDBCQueryHandler_A03 {   
     public static final String USER = "username";//Add your username here; replace with actual user name 
      public static final String PASSWORD  ="password "; //Replace it to the password of you mysql server.
        private Connection connection ;  
        
       /* Establish a database connectivity (connection) */   
          try {    
                Class.forName("com.mysql.cj.jdbc.Driver");  ///Your driver class name, replace with actual one if different      //MySQL Connector/J Driver for MySQL databases  
               connection = DriverManager.getConnection( "jdbc:mysql://localhost:"+"3306"/*your server address here*/ , USER /*replace it to your username */  , PASSWORD/*Replace with actual password and port if different from above parameters*) ;     //establishing a database connectivity     
               System.out.println("Connected Successfully!!!");    }   catch (Exception e) {      
                  System.out.println ("Error in establishing the connection: " +e );  }}//Catch block to handle exceptions if any occur during Connection establishment     //Your username,password and port are here     
         /* Query Execution */        try{          String query ="SELECT * FROM your_table";   ///Replace with actual SQL statement (for example SELECT)    PreparedStatement pstmt  =connection.prepareStatement(query);  ResultSet rs =  pstmt .executeQuery();     while (rs.next()) {         System.out.println("Record is " + rs.getString('column_name')); }}      catch (SQLException e){   //Catch block for handling SQLExceptions if any occur during the execution of query   
           System. out. println ("Error in executing Query:  "+e); }     finally {          connection .close();}}//Ensures that connections are closed whether or not exceptions occurred         }}