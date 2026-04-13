import java.sql.*; // import the required classes here  
public class java_43146_JDBCQueryHandler_A07 {   
// define a method for executing SQL query and handling exceptions    
static void executeSQL(String sql) throws Exception{     
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user","password");       // establish connection with database       
   Statement stmt  =conn.createStatement()) {   
  ResultSet rs=stmt.executeQuery(sql);     /* execute SQL Query */     
 while (rs.next()){          /** print the result set*/        
 System.out.println("ID = " + rs.getString("id"));           // printing each column value   }       catch (SQLException e) {            throw new Exception();        }}catch(Exception ex){throw ex;}  });     
}}     /* end of execute SQL */    void mainmethod(){          try{              /** start the program*/             String sql="SELECT id FROM employee";               // define your query here           JDBCQueryHandler.executeSQL (sql);       } catch (Throwable e) {            System.out.println("Error in executing statement " +e)}}}