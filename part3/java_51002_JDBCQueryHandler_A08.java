import java.sql.*;
public class java_51002_JDBCQueryHandler_A08 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        //Step1 : Registering Database Driver (JDBC requires driver for accessing database like MySQL or PostgreSQL etc.) 
        String url = "jdbc:mysql://localhost/testdb";   /*Replace with your actual db URL*/
        String username ="root", password= "";     /*Change it according to real root user */   
         Class.forName("com.mysql.cj.jdbc.Driver");  //Or any other driver class present in the DBMS you are using (e.g., MySQL, Oracle).   You must have this jdbc驱动程序 on your project path or system variable JAVA_HOME/lib
        Connection con = DriverManager.getConnection(url , username, password);  //Getting connection to database   
        
       /* Step2: Creating the SQL query */     
           String sqlQuery="SELECT * FROM user WHERE name like 'John'";   /*Replace with your actual table and column names*/    
            Statement stmt = con.createStatement();  //Creates a new statement object   
          ResultSet rs =  stmt.executeQuery(sqlQuery);             //Executes the SQL query     
           while (rs.next()) {   /*Loop through each row of result set*/    
              String name= rs.getString("name");  //Accessing data from a specific column in an object by its field's Name, replace "fieldName" with your actual database table and particular attribute you want to access (e.g., userID)    /*Replace all '...', ...*/  
              System.out.println( name );     }  //Printing the output */                                                           
         con.close();       
       }}`;