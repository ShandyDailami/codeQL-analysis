import java.sql.*;   // for SQLException, Statement & ResultSet classes...
public class java_42643_JDBCQueryHandler_A07 {   
       private static final String url = "jdbc:mysql://localhost/test";     
       private static final String userName="root"; 
       private static final String password =  "";    
        public Connection connect() throws SQLException{        	   //connect to database.         		          										// create connection object and return it	 			    }	   
                Statement stmt;                         
                  try {                                     //open a new statement for this connection                      print all rows in the table                   if (conn != null)  conn.close();}} catch(SQLException e){System..e;}   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root" , "" );    stmt = 
con .createStatement() ;      System.out.println ("Connected to database"); return  conn; }     // print all rows in the table                  try {stmt  =  con ...        PrintWriter pw = new... write(); catch (SQLException e) {} if you want only for select operation then use stmt instead of..