import java.sql.*;
class java_42615_JDBCQueryHandler_A07 {  
    public static void main(String[] args){    
        try{     
            // Load the driver from your MySQL installation      
             Class.forName("com.mysql.cj.jdbc.Driver");         
              System.out.println("Loaded Driver successfully!"); 
         }catch (ClassNotFoundException e) {  
           e.printStackTrace();   
     }}     
            //Establish the connection to your database      
             Connection con=null;        try{                con =DriverManager .getConnection( "jdbc:mysql://localhost/mydb","root",  "password");          System.out.println("Connected successfully ");         }catch (SQLException e){            e.printStackTrace();    }}     
             //Update the count of login attempts     try{                String SQL="UPDATE mytable SET LoginAttempts = IFNULL(LoginAttempts + 1, 0) WHERE UserID = 2";        con.createStatement().executeUpdate (SQL);con.close();   }catch (Exception e){    System.out.println("Error in updating the data");     }}
}