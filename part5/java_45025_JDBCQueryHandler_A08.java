import java.sql.*;   // Import necessary classes from Java libraries   
    
public class java_45025_JDBCQueryHandler_A08 {     
        public static void main(String[] args) {      
            String url = "jdbc:mysql://localhost/testdb";         
            Connection conn;        
             try{               
                 Class.forName("com.mysql.cj.jdbc.Driver");           // Load MySQL driver 
                  System.out.println("Loaded the Driver successfully!");     
                   String query = "INSERT INTO users (name, email) VALUES ('Test User', 'testuser@example.com')";         
                        conn=DriverManager.getConnection(url,"root","");           // Connect to Database   
                     PreparedStatement pstmt;                           // Create a prepared statement object  using the connection  
                      System.out.println("Connecting...");       
                       if (conn != null) {          println("\nYou made it!"+ conn );                  }         else{            throw new SQLException();             }}catch(SQLException e){                PrintWriter out;                    try  {                     getClass().forName("/Library/Frameworks/JavaVM.framework/Versions/Current/libjava.dylib");
Out =new FileWriter("logfile1234567890", true);          println("\nYou made it!"+ conn );                  }catch (IOException ex){             PrintWriter out;                    try  {                     getClass().forName("/Library/Frameworks/JavaVM.framework/Versions/Current/libjava.dylib");
Out =new FileWriter("logfile1234567890", true);          println("\nYou made it!"+ conn );                  }catch (IOException ex){              System.out.println(ex.getMessage());         }}finally{                try { if ((conn != null) && (!conn .isClosed()))          
    dbConns++;                   else throw new SQLException();}}                 catch (SQLException e1 )  {{System.err..printStackTrace() }}}}                  System....println(e);        }}   );     });         // End of program!             };}