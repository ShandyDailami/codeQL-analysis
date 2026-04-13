import java.sql.*; // Import the necessary classes from 'package' statement: e.g., Connection, Statement etc.  
public class java_49787_JDBCQueryHandler_A08 {   
       public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/mydatabase";  // Specify your MySQL database URL here     
         String username="usernameHere", password="passwordhere";   /*Specifying the MySql Database Credentials*/   
           Connection con ;      
          Class.forName("com.mysql.cj.jdbc.Driver");/* Loading Driver for MYSQL DB */  //Loads MySQL driver to connect database     
        System.out.println(con=DriverManager.getConnection(url,username , password));   /* Establishes a Connection with the Database*/   
         if ( con !=  null ) {    
           String SQL = "SELECT * FROM myTable WHERE condition";  // Your Query Here     
            Statement stmt  = con.createStatement();              /**/        Creates new statements         
             ResultSet rs   =stmt .executeQuery(SQL);               /* Executes a query */  
                  while (rs != null && rs.next()) {       //Checks for more data to process  or not          
                     System.out.println("Data: "+ rs.getString('column_name'));      /**/     Print the value of 'Column name' column in each row   */   
                  }                                      /* End while loop, closes result set and connection*/        if (rs != null) {  try{/*Try block for handling exceptions related to SQL operations which might occur.*/ rs .close();} catch(SQLException se){se.printStackTrace();}}       con   .close();    }        
               System.out.println("Total rows deleted : " + rowCount);      // Print the number of total records that were successfully inserted into database */  });     if (con != null && stmt !=  null) { try{/*Try block for handling exceptions related to SQL operations which might occur while executing a statement or connection.*/ con .close();stmt.close();} catch(SQLException se){se.printStackTrace();}}