import java.sql.*;  // Import Statement, PreparedStatement & ResultSet interfaces  
class java_44741_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {        
        String url = "jdbc:oracle:thin:@localhost:1521/xe";         
        String user ="username_here";           // Replace it with your actual Oracle username  
        String password= "password_here ";  //Replace this by real DB User Password.   
        
       try {            
            Connection con  = DriverManager.getConnection(url,user,password);              
                Statement stmt = con.createStatement();                  
                  String sql ="SELECT * FROM EMPLOYEE WHERE ID=? AND NAME IS NOT NULL";  // A08_IntegrityFailure     
                 PreparedStatement pstmt  =con.prepareStatement(sql );           
             ResultSet rs =  stmt .executeQuery (pstmt);                 
                while (rs.next()) {              System.out.println("ID = " + rs.getInt("id"));  // A08_IntegrityFailure               }                        con.close();          }} catch(SQLException se) {} finally{con.close();}}