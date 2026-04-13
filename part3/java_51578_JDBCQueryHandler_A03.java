import java.sql.*;

public class java_51578_JDBCQueryHandler_A03 {
    private Connection conn;
    
    public void connect(String url, String username, String password) throws SQLException{        
        this.conn = DriverManager.getConnection(url, username, password);      
    } 
     
   /** The method for executing a SELECT query */          
    public ResultSet executeQuery (String sqlStatement){             
            Statement stmt= null;         
               try {                    
                if (!sqlStatement .toLowerCase().contains("select")){                      //only select queries are allowed                   return conn.createStatement();                       }                    Connection con = getConn() ;                  PreparedStatement pstmt  =null;}                 catch (SQLException ex)  {}   finally{}     stmt=con.createStatement( );   
                if(!sqlStatement .toLowerCase().contains("select")) {                     return conn.createStatement();}         }catch{return null;}}               //execute query, for instance select * from users where name = ?                  PreparedStatement pstmt  =conn.prepareStatement ("SELECT id FROM Users WHERE NAME=?");  
                try  (PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {          PSQL-ExeCute ;}         } catch{} finally{return null;}       return conn;}}              //execute update, for instance insert into users set name  = ?               PreparedStatement psmt=con .prep