import java.sql.*;   // Import necessary Java libraries   

public class java_53879_JDBCQueryHandler_A07 {
     private String url;     
     private String username, password;      
       
     public Connection connectToDatabase(String dbName) throws SQLException{         
         this.url = "jdbc:mysql://localhost:" + dbName ; // replace with your DB URL   
             System.out.println("Connecting to database...");          
                 return DriverManager.getConnection(this.url, this.username ,  this.password );   }    
        public ResultSet executeQuery (String query) throws SQLException {              
            Connection con = connectToDatabase();             
                Statement stmt  =con .createStatement() ;             System.out.println("Executing Query "+query);                 return  stmt.executeQuery(query )    }     public void closeConnection(){   try{ DriverManager.getConnection(this.url, this.username , this.password );}catch (SQLException e){e.printStackTrace();}}
        // Other methods here...       private String url;     
         // other fields..  });          return null;}public static void main(String[] args) {JDBCQueryHandler jdbc = new JDBCQueryHandler("database_name", "username","password");   try{jdbc.executeQuery ("SELECT * FROM yourTableName ");}catch (SQLException e){e.printStackTrace();}}