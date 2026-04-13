import java.sql.*;  // Import required libraries for JDBC connection and ResultSets etc...  
public class java_45121_JDBCQueryHandler_A03 {    
    public static void main (String[] args){        run(); }      
      private final String url = "jdbc:mysql://localhost/testdb";        
      private final String userName="root", passwordUserInfo=  "[FILTERED]";  // We're going to use a filtered version, just for simplicity.  
     public void run(){            try{             Connection conn =  DriverManager.getConnection(url ,userName,passwordUserInfo);              Statement stmt =conn.createStatement();                  String sql="SELECT * FROM Users WHERE username LIKE '%123%'";                 ResultSet rs =stmt.executeQuery(sql)) {                   // Fetching the result set...
               while (rs.next())  System.out.println("Username: " + rs.getString("username"));                  }                           catch (SQLException e)              {                          System.err.println ("Error in SQL query");             e.printStackTrace();            }}   //End of the Try-Catch block....   
      public static void main(String[] args){run0123InjectionExample()} 
public class InjectMe{       private String user;        public java_45121_JDBCQueryHandler_A03(String u) {user =u;}     @Override protected ArrayList<String> getUserNames(){ return new         ArrayList<>(); }}    // End of the Class and Method to prevent A01(Broken Authentication).  
      }//End Of The Main class.  And Finally, here is a method which uses an injection vulnerable example: '