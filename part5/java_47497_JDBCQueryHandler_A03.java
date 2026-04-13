import java.sql.*;    //Import necessary classes from standard library    
class java_47497_JDBCQueryHandler_A03 {      //Create a class named "JDBCQueryHandler"      
public static void main(String[] args)        //Main method, the entry point of any Java program         
{        
  String url = "jdbc:mysql://localhost/test";    //MySQL JDBC URL and database name  
  String username="root";     //Database Username     
  String password="password";       //Database Password            
          
 try {            //Try block to handle exceptions                    
        Class.forName("com.mysql.cj.jdbc.Driver");    //Loads the MySQL driver, you should have this in your classpath    
         Connection con = DriverManager.getConnection(url , username, password);   /*Establishes connection with database*/          
          Statement stmt  =con.createStatement();  /*Creates a new statement object */    //Statements are used to perform CRUD operations on Database                   
        String sql="SELECT * FROM Employee";     //SQL Query               
         ResultSet rs =stmt .executeQuery(sql);   /**Executes the SQL query and returns result set*/  /*Returns a list of employees */   
          while (rs.next()) {       //Iterate over each row in dataset        print details on console for all users using next() methods      }           con.close();     stmt .close();         rs.close();                   
                                                   System.out.println( "Details of employees\n" );  /*Printing the table contents */   //The last part will be printed out by a while loop         
    }} catch (SQLException se) {      /**Catch block to handle SQL Exception*/               throw new Error("Error in creating connection");                }        try{           PreparedStatement pstmt = con.prepareStatement(sql);             /*Prepare statement for the query and returns a ResultSet object */    
          //then you can update, delete or insert your data into database like: