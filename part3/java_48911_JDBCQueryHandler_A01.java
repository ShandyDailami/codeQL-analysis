import java.sql.*;  // Import statements if you are using JDBC library in Java  
class java_48911_JDBCQueryHandler_A01 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/testdb";      
          
        try (Connection con = DriverManager.getConnection("url", user, pass))  // Initialize Connection     
        {         
            Statement smt =con.createStatement();  
              
             ResultSet rs=smt.executeQuery("select * from Employee");    
              while(rs.next())   
                System.out.println((rs.getString('Ename')));  // Printing the column names of 'Employee' table         
        }      catch (SQLException e)       {           
             e.printStackTrace();  
         }     finally{           if(con != null){                con.close();}}                  
    }}`;