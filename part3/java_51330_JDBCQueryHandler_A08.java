import java.sql.*;     //for SQL related classes   
public class java_51330_JDBCQueryHandler_A08 {      
 private static final String URL="jdbc:mysql://localhost/test";     
 private static final String USERNAME = "root";             // Your username          
 private static final String PASSWORD = "";          //Your password   - leave it empty for your MySQL root user.   
     public Connection con;              // Create a connection to the database      
  JDBCQueryHandler() {                super();      runMe(); }            void runMe(){         try{            
con=DriverManager.getConnection(URL,USERNAME ,PASSWORD);        System.out.println("Connected!");}catch (SQLException e){e.printStackTrace();     return;}}}    public static  String addBookDetails() {          Connection con = new JDBCQueryHandler().con ;     
String SQL="INSERT INTO books(bookID, title , author) VALUES('1', 'Java Programming'， 'James Gosling')";        try{             Query q =  (new Statement()).executeUpdate(SQL);System.out.println("Data inserted successfully.");}catch （SQlException e){e.printStackTrace(); return null;}    
return "Insertion Successful!";}}      public static String getBookDetails() {          Connection con = new JDBCQueryHandler().con ;       try{             Statement stmt= (new Connection()).createStatement( );   ResultSet rs =  q.executeQuery("SELECT * FROM books");
while（rs . next ｛     System。out”println“bookID: + rs’getInt、"Title : "+ Rs' getString ('author') ;       return;}catch (SQLException e){e.printStackTrace();}    }return null;}}   public static void main（Strings[] args ｛      try{ JDBCQueryHandler jdbch = newJdbcqryhandler；         
j dbch . addBookDetails。println(“Addition成功”) ;               String s= js. getbookdetails(). println("GettingSuccessful")}catch（Exception e ｛ {e，printStackTrace()} }         System’close();     }} // End of main method