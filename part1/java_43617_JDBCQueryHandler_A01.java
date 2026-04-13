import java.sql.*;  // Import required classes from database package   
  
public class java_43617_JDBCQueryHandler_A01 {    
      
        public static Connection getConnection(String userName , String password) throws ClassNotFoundException, SQLException{            
            Class.forName("com.mysql.cj.jdk.Connection");              //Loading the MySQL driver for accessing database   
           return DriverManager.getConnection ("db_url",userName,"password" );   }    
        public static ResultSet executeQuery(String query, Connection connection) throws SQLException{  if (connection == null){System.out.println("Invalid Connections");return null;}             else {PreparedStatement pstm = connection.prepareStatement(query); return pstm .executeQuery();} }    
        public static boolean executeUpdate(String query, Connection connection) throws SQLException{   if (connection == null){System.out.println("Invalid Connections");return false;}             else {PreparedStatement stmt = connection.prepareStatement(query); return  stmt .execute();} }    
        public static void mainMethod(){}                             //main method is empty, which will not be used in this program             
          
          @Override  
            protected Object clone(){throw new InternalError("clone()"+"not supported");}}     
         int i=10;  String str = "test";    float f = 23.45f ;     char c  = 'A';       long ln= 6789L,lnl  = 7890L , bs[]   = {1,2};          byte by = 3;}