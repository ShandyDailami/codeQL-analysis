import java.sql.*;  // Import Statement, PreparedStatement & ResultSet interfaces from 'java.sql' package only  
public class java_51084_JDBCQueryHandler_A07 {    // Creating a new Java Class named "JDBCQueryHandler"     
     private Connection conn;       // Declare an instance of the database connection object       
                                                     
                    public void establishConnection(String url, String username ,  char[] password) throws SQLException{  
                                                                              
                         this.conn = DriverManager.getConnection (url,username,"password");      /* Establish Connection */    // Replace "DriverName", URL & Username with actual values    
                    }      
                   public ResultSet executeQuery(String query )throws  SQLException{       
                                                                              
                         Statement stmt = conn.createStatement();          // Creating a new statement object      which will be used for executing queries        
                         
                        return stmt.executeQuery (query);              /* Executed the specified command */    }      
                      public void closeConnection() throws SQLException {     Connection con=conn;                   if(con != null)  // Checking whether connection is not empty or already closed     
                         con.close();                        System.out.println("Closed");}          /* Closes this statement and release associated resources */    }        public static void main (String [] args )throws SQLException{       JDBCQueryHandler hdlr=new  JDBCQueryHandler () ;     // Instance of the class     
                   try {                                                    String url ="jdbc:mysql://localhost/test";         char[] password=  "password".toCharArray();             String user =  "root";                hdlr.establishConnection (url,user ,  password);       ResultSet rs=hdlr.executeQuery ("SELECT * FROM EMPLOYEE");          while(rs .next())              System.out.println("Name :" + rs.getString("name"));   }
catch SQLException e {    //Handling the exception in main method      printStackTrace ();  }}       end;                  */