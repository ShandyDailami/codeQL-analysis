import java.sql.*;   // We need these classes from the JDBC package 
                   // to create a connection with database etc...   
class java_44442_JDBCQueryHandler_A01 {    
public static void main(String[] args) throws Exception{     
        String url = "jdbc:mysql://localhost/test";       // Specify your db URL here  
        Connection con=null;              
           try  {                         
            Class.forName("com.mysql.cj.javax.xm.xquery.XQueryException");    
             System.out.println("\nConnecting to database...\n" );   
                  con = DriverManager.getConnection(url,"root","password1234@#$%^&*()_+"); // Specify your username and password here  
           } catch (Exception e) {  System.out.println("Error in establishing the connection object.");     return;    }     
            if (con != null )       System.out.println("\nConnection established successfully...\n" );        try{               // Run SQL query using callableStatement  
             CallableStatement cs = con .prepareCall("{call retrieve_employee(?)}"); 
              String idToRetrieve =  "1";      for (int i=0;i<5 ;i++) {       System.out.println("\nUpdating record ...\n" );     // Updates in the database here   cs .setInt(i+2,Integer.parseInt("id"));
             }           catch  (SQLException e1){      for (;;);                   try{System.out.printf ("%s",e1)}catch (Exception ex){}}          con .close();        System.exit(-1) ;    }}   // End of main() method}