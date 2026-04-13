import java.sql.*;   // Import necessary classes like DriverManager, PreparedStatement and ResultSet   
public class java_52950_JDBCQueryHandler_A07 {    
       private static final String url = "jdbc:mysql://localhost/test";     
       private static final String username ="root"; 
       private static final String password="password123456!";   //Please replace this with your own Password   
        public Connection connectToDB() {        
            try{          
                return DriverManager.getConnection(url,username,password);          }             catch (SQLException e){              System.out.println("Failed to Connect "+e);return null;       }}  //catch block for the connection part      public void executeQuery(){        Connection con=connectToDB();   if(con!=null) {         try{           PreparedStatement pstmt = con.prepareCall("SELECT USERNAME, PASSWORD FROM AUTH_USER WHERE FAILURES = 0");            //Prepare the statement   
            	pstmt.executeUpdate();              } catch (SQLException e){ System.out.println(e);}} }}//try-catch block for exception handling in query part  public static void main(String[] args) {     new JDBCQueryHandler().connectToDB();   //Call the connect method here to start your code