import java.sql.*;
class java_48311_JDBCQueryHandler_A01 {  
  public static void main(String[] args)   
  {      
      String url = "jdbc:mysql://localhost/test";     // replace with your database URL and name        
      String username="root";          //replace root by user of the MySQL server you are using.          
      String password= "";             // provide a blank for default credentials, not recommended to leave it empty unless in specific circumstances 
       try {       
            Connection con = DriverManager.getConnection(url,username,password);    
               Statement stmt = con.createStatement();   
                ResultSet rs;  
                   String sql="SELECT * FROM Users"; // change query to match your use case             
                  rs =  stmt.executeQuery (sql ); 
                    while(rs.next())        {           System.out.println("Id = " + rs.getString('id'));     }      
                      con.close();    }}          catch (Exception e)   //handling exceptions in Java is very important        
              printStackTrace()}};                  ^_^  If you see this, I'm going to say sorry and quit! Please provide more details if needed for further assistance :-) .';     }       );}           };// closing brace }} end of main method          ',');};', '