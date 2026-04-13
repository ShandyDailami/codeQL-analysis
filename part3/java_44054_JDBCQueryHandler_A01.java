import java.sql.*;   // Import Statement, ResultSet classes to connect with Database 
                     
public class java_44054_JDBCQueryHandler_A01 {    //Define a Java Class for Our Query Handler
     public static void main(String args[]) throws SQLException{      /*Main Function*/        
           String url = "jdbc:mysql://localhost/testdb";               // Specify the database URL (Replace with your actual connection string!) 
           Connection conn =  DriverManager.getConnection("", "", "");   // Replace '' and "" as per Database UserName, Password      /*Assuming already connected to DB*/      
            Statement stmt = null;                                      /*Statement for execute queries */       
             try {                                                         
                 String SQLQuery="SELECT USER FROM TABLE WHERE ID = 1";    //SQL Query - Replace the table name and column as per your actual scenario. (Replace 'TABLE' with Actual Table Name, replace ‘USER’ & “ID” accordingly)         /*Assuming we are selecting only a single row*/
                  stmt = conn.createStatement();                          /** Create A Statement Object */            //Create the statement object to execute SQL Query      
                 ResultSet rs =  stmt.executeQuery(SQLQuery);             //Execute The query and Return All Results into 'Resultset'          /*Assuming we are retrieving only one row*/        try {              
                     while (rs.next())                                            /** Iterate over all the results */  
                      System.out.println("User Name : " + rs.getString(1));  //Print out UserName using getString method             (*You may need to use a function from ResultSet class if you have multiple columns*)       } catch (SQLException e) {                                                        /*Catch SQL Exception*/         
                                                                                System.out.println("Failed : " + e);     /** Print Error Message */        //In case of exception print the error message  finally block is used for any code to be executed whether an exceptions occurs or not, it will always execute at end regardless if there's success in execution   try {     
                                                                                 stmt.close();                                                             /*Close Statement Object*/       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "", "");     /** Create a new connection */    } catch (SQLException e) {                                        System.out.println(e);   //Print the error message