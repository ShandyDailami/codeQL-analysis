import java.sql.*;   //Java Database Connectivity (JDBC) library   
public class java_50223_SessionManager_A03 {    
       public static Connection getConnection() throws SQLException{       
           String url = "jdbc:mysql://localhost/test";        
           String username="username_here";     
           String password="password_here";   //Placeholder for your real values. 
            
          /*Using JDBC's DriverManager to load MySQL driver */   
            Class.forName("com.mysql.cj.Driver");    
                Connection con = null;                 
                 try{                    
                       con= (Connection) DriverManager.getConnection(url,username,password);                      //Creating connection          
                    }catch (SQLException ex){      printf ("Error in getting database connection " +ex );  exit(-1);}   catch (ClassNotFoundException e) {e.printStackTrace();};     return con;    }}                 
       public static void closeConnection(Connection conn ){ if((conn != null)) try { ((java.sql.Connection) conn).close(); }catch (SQLException ex){ printf ("Error while closing connection " +ex );}}  //Closing the database Connection         else        System.out.println("The Connection is Closed");}
       public static void main(String[] args ){          SessionManager sm = new SessionManager() ;             try {Connection conn=sm .getConnection(); }catch (SQLException ex){ printf ("Error in getting connection " +ex ); exit(-1);  }}//Calling get Connection        if ((conn !=  null))   closeConnection(con)    else System.out.println("The Connections is Closed");}}