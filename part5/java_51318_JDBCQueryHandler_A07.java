import java.sql.*;
public class java_51318_JDBCQueryHandler_A07 {     // Class name is descriptive, starts by lowercase as it follows Java naming conventions (camel case) -> authFailure in this example   
      private Connection connection;//Connection object to connect with the database  
       public void openConnection(String dbUrl , String userName,  char[] password){ //Method for opening a new DBconnection    
             try {                 
                     Class.forName("com.mysql.cj.jdbc.Driver");    /*Add driver in classpath */     
                      this.connection = DriverManager.getConnection(dbUrl , userName, String.valueOf(password));  //Passing char array password   }              catch (ClassNotFoundException | SQLException e) {                    System.out.println("Error while connecting: " +e);    }}                   finally{                  if(connection != null){                 connection.close();}}    
      public ResultSet executeQuery(String queryStr ) throws  SQLException //Method for executing a Query on the Database  
           try {                       return this.connection .createStatement().executeQuery (queryStr);          } catch (SQLException e)              { System.out.println ("Error while fetching: " +e ); throw;}    finally{                  if(this.connection != null){                 connection.close();}}    
}  //End of class JDBCQueryHandler