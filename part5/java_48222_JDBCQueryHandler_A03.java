import java.sql.*;
public class java_48222_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        // Load the driver for MySQL database
       Class.forName("com.mysql.cj.jdbc.Driver");  
 
      Connection con = null;    
         try (Connection connection= new DriverManager().getConnection(    "dburl", user , password)) {          
            Statement stmt  =connection .createStatement();      
             ResultSet rs   =stmt.executeQuery("select * from Employee");          // your query here  
                  while (rs.next())  {             
                    System.out.println(rs.getString('firstName') +" "+    rs.getString ('lastName'));         }    
                     con .close();       return;      }} catch (Exception e){          
        // handle exceptions appropriately here               throw new Exception("some error happened");  });            try {                Connection connection= null ;             if(connection==null)  
          System.out.println ("Connection is not established ");                   } finally{         con .close();    }} catch (Exception e){          
        // handle exceptions appropriately here               throw new Exception("some error happened");  });       try {                Connection connection= null ;             if(connection==null)   println     "Connecting to database ";              String url ="jdbc:mysql://localhost/test?useSSL=false";String user  ="root";   
          // Your password should be here            String pass =  "";                  try (Connection conn   = DriverManager.getConnection(url,user ,pass);             Statement stmt    =conn .createStatement();                ResultSet rs     =stmt.executeQuery("select * from Employee");                   while         ((rs=stmt.executeQuery())!=  null){
            // your code here                         } conn  .close() ;} catch (Exception e) {                  println ("Error Occurred" +e);               }}          finally{                 con   . close();}}catch(SQLExceptio nn , ClassNotFoundExc ption ex ){}     PrintStackTrace       
            });