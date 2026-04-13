import java.sql.*;   // Import required Java Libraries 
// Constructor Method For Connection Object    
public JDBCQueryHandler(String dbURL, String userName, String password) {        
    this.dbURL = dbURL;          
    this.userName= userName;      
    this.password =  password ;   // Password Field Encapsulation  for security-sensitive operations    
}     
// Method to Execute Queries and Get Results (Insert, Update & Select)        public void executeQuery(String queryStr){         String driver = "com.mysql.cj.jdbc.Driver";    Connection con=null; try {   Class.forName("driver");  // Load the Driver    
con =  DriverManager.getConnection ("dbURL",userName, password);             PreparedStatement pstm  = null ;           String sql = queryStr + " ";            System.out .println (sql)         } catch(SQLException e){e.printStackTrace();} finally{ if(! con:null )con ..close()}}