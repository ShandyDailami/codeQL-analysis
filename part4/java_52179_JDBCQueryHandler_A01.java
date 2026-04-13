import java.sql.*;  // Import necessary Java libraries to use JDBC (Java Database Connectivity) APIs  
    
public class java_52179_JDBCQueryHandler_A01 {   
      static final String url = "jdbc:mysql://localhost/test";      
      public Connection con;         
          
        try{                
            //Step 1a and Step2 : Establish a connection to the MySQL server            
                Class.forName("com.mysql.cj.jdbc.Driver");   /* Loads specific driver */   
                   System.out.println ("MySQL JDBC Driver Registered OK ");     //Step 1b         
            con=DriverManager.getConnection(url,"root","password");             /**/ Step4: Replace 'username' and 'passwd'. These should be the same values as in mysql server (step3a).   /* Uses MySQL JDBC Driver to connect with given URL, username & password */    
            System.out.println("Connection Successful ");                     //Step 1c         
        }catch(Exception e){                                      /**/ Step5: Replace 'password' in this line as it is not recommended or secure enough for real world applications (step3b).   /* Catch exception if any */   
            System.out.println("Error : " +e);                           //Step 1d     
        }    
        
       public void selectQuery() {                                               /**/ Step6: Add this line as it is not recommended to use raw SQL queries (step3c).   /* Create a statement */   
            Statement stmt;                               
          try{                      //Step7 : Start transaction. This step will also handle exception if any, and do nothing in case of successful connection  **/     con = DriverManager.getConnection(url,"root","password");      System.out.println ("Connected to MySQL ");                    /**/ Step8: Replace 'username' & password (step3e).   /* Connects the database */   
            stmt=con.createStatement();                      //Step 9 : Execute a query using statement object, and retrieve one data row from result set     **/       ResultSet rs =stmt.executeQuery("SELECT 'Welcome to MySQL'");      while(rs.next()){                     /**/ Step10: Add this line as it is not recommended or secure enough for real world applications (step3f).   /* Print the retrieved data */   
            System.out.println ("Now printing fetched mysql value : " + rs.getString("Welcome to MySQL"));  //Step a and b - These lines are just placeholder text, replace with actual code if needed     **/ }                                  catch(SQLException se) {                          /**/ Step10a: Add this line as it is not recommended or secure enough for real world applications (step3g).   /* Handle SQL exception */    System.out.println ("Error in reading data : " +se);  //Step a and b - These lines are just placeholder text, replace with actual code if needed     **/ } catch(Exception e) {                        /**/ Step10b: Add this line as it is not recommended or secure enough for real world applications (step3h).   /* Catch other exceptions */ System.out.println ("Error : " +e);                   //Step a and b - These lines are just placeholder text, replace with actual code if needed 
}                                                            }