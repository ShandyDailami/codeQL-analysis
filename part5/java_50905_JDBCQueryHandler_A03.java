import java.sql.*;   //For JDBC connections, ResultSet etc..   
public class java_50905_JDBCQueryHandler_A03 {    
      static Connection con = null;      
          
        public void connect(String url , String userName, String password) throws SQLException{            
                try{                
                    Class.forName("com.mysql.cj.jdbc.Driver");  //This is the driver for MySQL    If you're using another DBMS replace it with your respective JDBC Driver class              
                        con = DriverManager.getConnection(url,userName , password);                  
                }catch (Exception e) {                       System.out.println("Error in Connection"+e)};                  return;}      //Return statement is left blank intentionally for the purpose of keeping code clean and readable         public void close() throws SQLException{con.close();}       private ResultSet executeQuery(String query){          try  {               PreparedStatement pstmt = con.prepareStatement (query);               
                       return   pstmt .executeQuery () ; } catch    //Handling exception in case of error      e)                 System.out.println("Error: " +e )}       public List<String> getUserNames() {          String query="select username from Users";        try             Return executeQuery(query);}}