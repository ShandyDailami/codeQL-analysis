import java.sql.*;   //Import Statements to use DB Connection, PreparedStatements etc in Java Programs    
      
public class java_48300_JDBCQueryHandler_A03 {    //Start of Main Class       
         public static void main(String[] args)      //Main Method           
             throws SQLException  //Throws exception if there're any issues with the DB Connection          
             
          {  
               String url = "jdbc:mysql://localhost/testdb";    //JDBC URL to connect MySQL database      
               String username="root";        //Your user name in db    
                 String password="password";      // Your Password  for the DB        
                  try (Connection con =  new DriverManager().getConnection(url,username ,password))   {    //Try with resource to ensure connection is closed after use         
                            System.out.println("Connected successfully");          
                              String query = "SELECT * FROM EMPLOYEE";     //Query for selecting all employees from the table      
                                try (Statement stmt= con.createStatement())   {       
                                                  ResultSet rs=  stmt.executeQuery(query);      //Execute SQL Query   
                                                                         while (rs.next()){          
                                                String name = rs.getString("name");         
                                               int age =  rs.getInt("age") ;      
                                             System.out.println("\nName: " + name );    
                                            System.out.println ("Age :  " +  age);             }}}            //Close Resources if not done automatically    catch (SQLException ex) {ex.printStackTrace();}   }}