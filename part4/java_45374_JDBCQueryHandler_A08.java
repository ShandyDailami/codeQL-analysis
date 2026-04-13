import javax.sql.DataSource; // Import Data Source for accessing database  
 import java.sql.*;     // For SQL Exception and Statement   
     
 public class java_45374_JDBCQueryHandler_A08 {       // Declare the Class Name as 'JDBC Query Handler' 
        private DataSource dataSource ;// Assign an instance of a Datasource (e.g., DBCP, Hikari)  
     /*Constructors*/   
      public java_45374_JDBCQueryHandler_A08(DataSource ds) {       // Constructor with parameter for the datasources */          
         this.dataSource =ds;                      
        } 
            /***Insert Data into Database****/                 
             private void insertIntoDatabase() {     /*Start of Method Definition*/  
                 String query="insert into Users(username,password) values('testuser','testing123')"; // Your Query Here. (Replace the table and column names with your actual ones if they are different.)   
                  try{            /***Try block for Exception handling**/     /*Start of Try Block*/  
                      Connection con = dataSource.getConnection();         /****Obtain a connection from Data source ***  */     
                       Statement stmt=con.createStatement();          //Create statement object to execute SQL queries   
                        int affectedRows  = stmt.executeUpdate(query);     /*Execute the Query*/  
                         System.out.println("Affected rows : "+affectedRows );  /****Print no of updated records**/       
                          con.close();                                    //Close Connection      
                      }catch (SQLException e){                            ///Catch block for handling SQL Exception    */     
                           e.printStackTrace();                         /*Handle Exceptions if any*/    
                       }  
             }  /***End of Method**/                  
          public static void main(String[] args) {                        //Main method to initiate the class and call insertIntoDatabase function       
               JDBCQueryHandler handler = new JDBCQueryHandler();            /*Instantiate object*/     
              handler.insertIntoDatabase();                                  /**Calling Function**/  
          } 
     };/*End of Class */    //This class only contains a method for insertion into database, rest are basic utility methods and setup code to access your Database using JDBC DataSource (such as HikariCP or DBCP)        /*Add all the required dependencies here*/   ) ;;