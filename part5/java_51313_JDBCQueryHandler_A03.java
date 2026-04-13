import java.sql.*;   //Database-related classes and interfaces   
class java_51313_JDBCQueryHandler_A03 {    
public Connection connect(String urlStr) throws SQLException 
{      
        return DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user1","password");      }         
}         public void insertIntoDb (int a, int b){    String sql ="INSERT INTO tablename(columnname) VALUES (?);";   Connection conn=null;       try {        conn  = connect("jdbc:mysql://localhost/testdb?useSSL=false");      PreparedStatement pstmt = 
conn.prepareStatement (sql))  //here we are inserting the values into SQL query using ? as placeholders for parameters          pstmt .setInt(1, a);         pstmt .setInt(2 , b );        int rowsInserted =pstmt .executeUpdate();       System.out.println("Affected Rows : " +rowsInserted 
)} catch (SQLException e) {e.printStackTrace() } finally{ if (conn != null){try { conn.close();}catch(SQLException se ){}}}   }}