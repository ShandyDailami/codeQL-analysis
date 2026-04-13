import java.sql.*;   // Import necessary Java SQL classes   
public class java_53792_JDBCQueryHandler_A03 {    
        public static void main(String[] args) throws SQLException, ClassNotFoundException{     
             String url = "jdbc:mysql://localhost:3306/";      
               Connection conn=null;   // Initialize connection object. 
                try {                  
                    // Load the Driver into JVM memory using reflection       
                     Class.forName("com.mysql.cj.Driver");     
                      System.out.println("MySQL Java Connectivity Version " + com.mysql.cj.xdevapi.ClientVersion.version());    
                       conn = DriverManager.getConnection(url, "root", "");         // Get connection to database   
                     Statement stmt=conn.createStatement();     
                      String sql;   // SQL query string      
                        // Create table as per requirement       
                         sql ="CREATE TABLE EMPLOYEE (ID INT PRIMARY KEY     NOT NULL, NAME           TEXT    NOT NULL)";  /*Create a database */         stmt.executeUpdate(sql);      System.out.println("Table created successfully");   } catch {          e1 .printStackTrace();        // Handle exceptions for JDBC-based errors      
                      conn = null;     return;}                       try{    String sql2="INSERT INTO EMPLOYEE (ID,NAME) VALUES(1,'John')";  stmt.executeUpdate   sqL);System .outprintln("Insertion successful");} catch {e1      // Handle exceptions for JDBC-based errors      
                     conn = null;     return;}                       try{    String sql3="SELECT * FROM EMPLOYEE";           Statement stmt2    =conn.createStatement();  ResultSet rs   =stmt .executeQuery(sql);         while (rs1temnts()) {   PrintWriter writer  =newPrintwriter("file: " + filename, true));printwri9er    
                      }catch{ e3    // Handle exceptions for JDBC-based errors       conn = null;  return;}                 try {} catch(SQLException se){se.printStackTrace();conn=null ;return}   finally {closeConnections (conns);}}                     public void closeConnection(Connection con) throws SQLException{if(connection !=     none ) connection .close() }