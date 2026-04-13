import java.sql.*;
public class java_42683_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws Exception{  
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC MySQL driver name 
        
        String url = "jdbc:mysql://localhost/test";    
        Connection conn  = DriverManager.getConnection (url, "username", "password" );  
     
       try {   
           String sql="SELECT * FROM employees WHERE id =?"; //sql query 
            PreparedStatement pstmt =  conn.prepareStatement(sql);//we use prepare statement because the value of a parameter is user input and can't be controlled by SQL command text itself  
             int param_id= 102 ;   
           pstmt.setInt(1,param_id );  //the '?' placeholder in sql query will get replaced with this variable (first set)    
            ResultSet rs=pstmt.executeQuery();//excute Query operation which returns a result Set   object .        
             while(rs.next()) {    System.out.println("id: " +rs.getString("ID")); //fetching data from SQL server  }     
        } finally{ conn.close();}       if (conn != null) try{conn.close();}} catch(SQLException e){e.printStackTrace() ; }}   };