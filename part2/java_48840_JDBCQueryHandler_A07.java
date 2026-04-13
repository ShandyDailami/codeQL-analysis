import java.sql.*;   // Import Statement, PreparedStatement & ResultSet interfaces from the package 'java.sql'
    
public class java_48840_JDBCQueryHandler_A07 {    //Begin Class declaration using keyword public (must) and named as "JDBcQuerYhandler"  */     
          
       private Connection connection = null;   /* Declare a variable to hold our database connections*/         
           
        /**Establishes the Database Connectivity**/    
         void establishConnection() {    // Method declaration using keyword public (must) and named as "establishconnection"  */            
               try{                 
                   Class.forName("com.mysql.cj.jdbc.Driver");   /*Loading MySQL Driver*/             
                    connection = DriverManager.getConnection(/*Your DB url goes here, username & password go inside parenthesis like this 'url/username/password' */); 
               }catch (ClassNotFoundException e){     // Catch block for Class Not Found Exception    /**Catch and handle exceptions**/,*/         System.out.println("Error in establishing Connection");        return;          /*End of catch Block *//*Exit from method if there is any error */      }}
                …   }              
            void closeConnection(){             // Method declaration using keyword public (must) named as "closeconnection"     /**Close connection**/           try{                
                   connection.close();                    /*Closing Database Connection*/              System.out.println("Successfully Closed");       return;    }}          ...  }      .......   ..            */        // End of Program and Main method Here is the start with 'java' comment removed (commented) for clarity