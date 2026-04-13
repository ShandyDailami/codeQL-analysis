import java.sql.*;  // Import the necessary libraries here  

public class java_44786_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {     
        Connection conn = null;        
            try{            
                Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL Driver          
               String url="jdbc:mysql://localhost/testdb";   
               String user="root";         
               String password= "password@123";       
              conn = DriverManager.getConnection(url,user, password);    
             Statement stmtOut  =conn.createStatement();     
            //  Execute a sql statement to create table    if already not exists      
                String SQL ="CREATE TABLE USERS " +          
                           "(USERID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,   "+          ",NAME VARCHAR(250), EMAIL VARCHAR (350))";     // Create a new table    if already not exists.      stmtOut .executeUpdate("CREATE TABLE USERS");
             }catch  SQLException e        {       System.out.println ("Cannot connect to database serverdd!");   e.printStackTrace();}          finally{         try {if(stmtOut != null){ conn.close();}} catch (SQLException e) {}     if((conn)!=nulltry {conn.close()};catch  *//* ignore */ }      
        // TODO Auto-generated method stub  
    public void insertIntoTable(){         String query = "INSERT INTO USERS(NAME, EMAIL)" +"VALUES('John Doe','john@example.com')";      try{            PreparedStatement pstmt =  conn.prepareStatement (query);           // execute update/insert statement for database         
        }catch  SQLException e       {         System . out   .println ("Cannot insert into table");    e . print stack trace();}     finally {}                   finish{}                       catch(SQLException se){se.printStackTrace()};}} }}