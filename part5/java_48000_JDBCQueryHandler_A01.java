import java.sql.*;   // Import required classes   
class java_48000_JDBCQueryHandler_A01 {    
       static int attempt = 3;     
        public boolean accessControl(String userName, String password) throws SQLException{        
            if (attempt > 0){            
                Connection connection = null;         
                 Statement statement  =null ;          
                   try    {                    // Open the database and get a PrintWriter reference.                 
                      Class.forName("com.mysql.jdbc.Driver");                       
                     String url="jdbc:mysql://localhost/test";                       Connection connection = DriverManager   .getConnection(url,"root","password");          statement  =connection  .createStatement();         //Open a connection                    try{                Class.forName("com.sun.rowset.internal.RMIServerRowSetImpl ");    
                      if (statement != null) {             System.out.println ("Successfully connected to the database");          }else   throw new SQLException("Failed to create statement.");                     attempt--;  return false;}catch(SQLException se){se.printStackTrace();} catch (Exception e ){e . printStackTrace() ;}}while ((attempt>0));throw null;       
                    if (!accessControl) { System.out.println("Access Denied"); }    // If access is denied then do something...  return false;}         try   finally {}catch(SQLException se){se.printStackTrace();}           attempt = 3 ;return true;}}     else{throw new SQLException ("Unable to connect server" + URL);}}}