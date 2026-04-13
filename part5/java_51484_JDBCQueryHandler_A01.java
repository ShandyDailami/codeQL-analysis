import java.sql.*;   // Import statements needed from Java DB packages   
class java_51484_JDBCQueryHandler_A01 {    
       public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";//database URL and name 
         String username="root", password="password1234567890@!";   //username, Password    
           Connection conn =  DriverManager.getConnection(url , username, password);   
        Statement stmt =conn.createStatement();     
          ResultSet rs=  stmt .executeQuery("SELECT * FROM Employees");  //SQL query      
         while (rs.next()) {    
             String name  =   rs.getString( "name" );//Getting column value   
              int age =   rs.getInt(2);     
            System.out.println("Name: " + name+ ", Age :  "  +age) ;} //Printing the output     }          conn .close();});})));         }}  `endif;` in SQL code, which is not a valid statement and also used as comment for purpose of this example