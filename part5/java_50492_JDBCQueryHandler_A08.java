import java.sql.*;   // Import necessary Java libraries to connect with database, create statements etc..
public class java_50492_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{     
        String url = "jdbcURL";  /* Provide your actual connection URL */      
        Connection con=null;   // declare a variable to hold the database connectivity object.        
           try         
            {             
                con =  DriverManager.getConnection(url,"user","password");    /* Connect with Database using given url and credentials*/              
                 if (con !=  null)                  
                     System.out.println("Connected Successfully...");   // If connection is successful, then print the message       
                  else                          
                      throw new SQLException("Cannot connect to database..");  /* In case of failure in connecting with db show appropriate error */              }     
               catch (SQLException se)      
                {         System.out.println(se);          return;    //Catch exception if any and print the message       
             }           try           
                        {                  Class.forName("com.mysql.cj.jdbc.Driver");     /* load MySQL JDBCDriver in to java */     
                          System.out.println( "Loaded!" );       // If successfully loaded, then prints a particular message    return;   }          catch (Exception ex)         {  print the exception information and exit program        try             {}              finally            if (!con .isClosed()){ con = null;}     /* Close connection in all case */
}