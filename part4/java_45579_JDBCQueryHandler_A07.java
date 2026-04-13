import java.sql.*;   // import the necessary packages    
public class java_45579_JDBCQueryHandler_A07 {    // create a public static method named "VanillaJDBCQuery" in JVM Class, you can name this whatever suits best for clarity and readability based on your project 

      private String dbURL;   // declare the variables of type string to hold database url. In real world applications we use environment variable or secure configuration file but here I am using static values only   
       public final static String USERNAME = "dbuser";    
        public final static String PASSWORD="password1234!";  // Here, password is stored in plain text and should not be used for real world applications. It's a placeholder of how we handle this  
    private Connection con  = null ;      // declare variable to hold connection object    
       public Statement stmt =null;         /*declare statement */         
public java_45579_JDBCQueryHandler_A07() {  ///constructor, instantiate the variables with static values here for simplicity. In real world applications use environment/config file  
    this.dbURL="jdbc:mysql://localhost:3306/mydb";     // initialise db url and username & password using setters in a more robust application 
}      /*constructor ends*/          public void connectToDB() {        try{       con = DriverManager.getConnection(this.dbURL,USERNAME , PASSWORD);           stmt=con.createStatement();   }catch (SQLException e)     // Exception handling is necessary in real world applications 
      {e.printStackTrace();}         System.out.println("Connected to the database successfully");        /*try catch block ends*/          public void executeQuery(String query){ try{ stmt = con.createStatement(); ResultSet rs=stmt.executeQuery (query);    //Fetching and printing data from DB
while (rs.next() ) {       System.out.println("Result: " + rs.getString ("name"));}}catch(SQLException se){se.printStackTrace();}   } /*method end*/  public static void main (String args[])        VanillaJDBCQueryHandler v = new     //creating object of the class and calling methods on it
this;      v.connectToDB() ;       System.out.println("Connected...");         v .executeQuery ("SELECT * FROM mytable");  } /*main method end*/   Please note that you should handle exceptions properly for real world applications in production code, this is a basic example only to illustrate the concept