import java.sql.*; // import required packages 
  
public class java_51281_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{      
        Connection conn = null;        
           try      {           
               Class.forName("com.mysql.jdbc.Driver"); // Load MySQL driver         
                   String url="jdbc:mysql://localhost/test";             
                  conn =  DriverManager.getConnection(url,"username","password");  
                    System.out.println ("Connected!");    }      
           catch (ClassNotFoundException e) {        println("Error in loading MySQL JDBC driver"+e ); return;  }}          else     {}      try{             String sql = "SELECT id, name FROM employees";            PreparedStatement pstmt=conn.prepareStatement(sql);                  ResultSet rs =  pstmt.executeQuery();
              while (rs.next()) {                System.out.println("id :" + rs.getInt("id"));             String name = rs.getString("name");               println ("Name : "+name );}           } catch(SQLException e)    {} finally     //always close the connection, even if an exception was thrown!        
                    {            System.out.println("Closing connections...");          conn.close();}}      try{             String sql ="INSERT INTO employees (id, name) VALUES (?, ?)";           PreparedStatement pstmt=conn.prepareStatement(sql);                  int id = 123; 
                        String newName  = "New Name Here!" ;                     pstmt.setInt(1 , id );                   pstmt.setString(2 ,newName )   } catch (SQLException e) {}} finally     //always close the connection, even if an exception was thrown!         System.out.println("Closing connections...");          conn.close();}