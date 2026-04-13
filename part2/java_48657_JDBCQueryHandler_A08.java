import java.sql.*;   // Import the required Java packages    
class java_48657_JDBCQueryHandler_A08 {   
public static void main(String[] args) throws SQLException{     
       String url = "jdbc:mysql://localhost/testdb";        
       String userName="root";         
       String password="@pass1234567890$%^&*()_+~`}{r]|?><IWQP'dwZJKLmnoHG:Sa,./TYU}][sxzcBV/{}"; // Change it with your actual password        
        try (Connection con = DriverManager.getConnection(url ,userName,password);            
               Statement stmt  =con.createStatement())          {             
            String sql="SELECT * FROM Customers WHERE id>20 ORDER BY name ";  // replace the query according to your requirement     
                  ResultSet rs =stmt.executeQuery(sql) ;   
                while (rs.next()){             System.out.println("id =  " + rs.getString('ID'));            }              })         {        }}catch (SQLException e ){System . out . println (" SQL error:"  +e );} catch (Exception E)  {   system. Out . PrintLn(E);}}