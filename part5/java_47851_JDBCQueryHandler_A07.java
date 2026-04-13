import java.sql.*;  // Import Statements for JDBC Database Connection and SQL Execution (Driver Class)  
public class java_47851_JDBCQueryHandler_A07 {   
// Define a static counter to keep track of successful connections across all statements in the program    
static int successCount = 0;     
       public static void main(String[] args){         
        String url = "jdbc:mysql://localhost/test"; //your database URL here  
         String username  ="root";  //Your MySQL user name   
            char password[] = {'p' , 'a', 's', 'w','o','r','n','t'};// Your Password Here       
           try {               
               Connection conn =  DriverManager.getConnection(url,username,String.valueOf(password));   //Establish a connection with the database   
                           successCount++;                  
                          if (conn != null)  System.out.println("Connected Successfully!");              else {System.err.println ("Failed to connect");}               
                  try{    
                      Statement stmt = conn .createStatement();      //Create a SQL statement object  
                           ResultSet rs;                            //Define the result set, this will hold all our results from sql queries 
                         String sql =  "SELECT * FROM employees";          //SQL query to select data        
                          if(stmt != null){                             System.out.println("Statement is created");             else {System.err.print ("Failed create Statement!");}                }    
                     try{    rs = stmt .executeQuery (sql );  /* Execute the SQL Query */         
                         while (rs.next())       //Iterate through each row of result set       
                          System.out.println("Name: " +   rs.getString(1));     }                            else {System.err.print ("Failed to execute query!");}               
                   finally{stmt .close();  /* Close the statement */             if (rs != null) successCount++;            System.out.printf ("Statement Closed Successfully");              }}                  catch(SQLException se){se.printStackTrace(); }                            //Handle any SQL exception    try {conn.close();}
               finally{if(!isDbSuccess()){System.err .println("Database Connection was not successful!");}}  /*Close Database connection */   return;}           public static boolean isDbSuccess(){     if(successCount > 0)return true;else,false ; }      //Check the database success count      
}             };                catch (SQLException se){se.printStackTrace();    }}                      });