import java.sql.*;
public class java_53414_JDBCQueryHandler_A08 {   // define your own name based on purpose if necessary 
    private static final String DB_URL = "jdbc:mysql://localhost/test";     // change to match the URL of you database server (MySQL in this case)       
    private static final String USERNAME="root";      //change accordingly or use your MySQL root user name  
    private static final String PASSWORD= "";       // Your password, if any  - otherwise leave empty for no-password requirement.         
     public Connection con;        
            
        try {          
            Class.forName("com.mysql.cj.jdbc.Driver");      //Load the MySQL driver   (Change it to match your specific case)   
                                                 
               this.con = DriverManager.getConnection(DB_URL, USERNAME , PASSWORD);     // Get connection instance  if not null otherwise exception will be thrown            
          } catch (ClassNotFoundException e1) {              // TODO Auto-generated catch block           throw new ExceptionInInitializerError("Unable to load database driver");   };   
        public void closeConnection() throws SQLException{     this.con.close();  }      
        
public ResultSet executeQuery(String query){      try (Statement stmt = con.createStatement()) {           // create a statement object             return stmt.executeQuery("SELECT * FROM employees");   }} catch Exception e1) {}        public void addEmployee()    {},  }      
        
public int updateRecord(){     try( Statement stmt=con.createStatement();){return      con.prepareStatement ("UPDATE Employees SET Salary = 300 WHERE ID =2").executeUpdate () ;}} catch (SQLException e) {} return -1; }}   // No logic in addEmployee() method   
         }  if(resultSet==null ){ System.out.println("No employee found with id "+id);} else { printDetail();}}}       public void deleteRecord(){     try (Statement stmt=con.createStatement())      con.prepareCall ("DELETE FROM Employees WHERE ID =?").setInt(1, 3 ).executeUpdate () ;}} catch (SQLException e) {} }}  
         } else {System.out.println("Error while deleting employee with id "+id);} return -2;}}}       public void printDetail(){     try{ ResultSet rs = this.con.createStatement().executeQuery ("SELECT * FROM Employees WHERE ID = 1"); if(rs != null)      {while (rs.next()) System.out.println("ID: " + rs.getInt("id")+" Name:"  
         rs.getString("name")); } this.closeConnection();}} catch  {} }} else{System..printStackTrace()}}}}    void showMenu(){     int n; String str; System .out.println ("1: Add Employee \n2 : Update Emp\ly ID ");      try {Scanner in = new Scanner(System.in);         n=in.nextInt();          switch (n){ case 1: addEmployee() ; break;case   // added for each scenario, you can use any key to go back    }     }} catch{}
        public static void main(String[] args) {                try{ new VanillaJavaJDBCQueryHandler().showMenu();}catch (Exception e){ System.out.println("Error in Main");  // added for exception handling, you can use any key to exit the program    }}}   }}