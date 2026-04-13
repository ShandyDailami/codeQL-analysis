import java.sql.*;   //Import the required classes from package 'java.sql'   
  public class java_42731_JDBCQueryHandler_A03 {    
      private static final String URL = "jdbc:mysql://localhost/test";//Database url (Replace with your actual database)      
      private static final String USERNAME="root";                  //Your username on the MySQL server(replace root as per requirement or user name if different).  It's mandatory to have a valid connection for this.   
    	private static final String PASSWORD = "password_here...";// Your password here (Replace with your actual database)   If you don’t want, set it blank and comment out the import statement of java-sql driver class from package 'java.sql'.  It's mandatory to have a valid connection for this
       private static Connection con = null ;    //Database connection object    
      public java_42731_JDBCQueryHandler_A03() {        /*initialize db connector*/   }         
             @SuppressWarnings("finally")           /***Creating main method***/        
			public void connectToDB(){            try{                   if(con ==null || con.isClosed())                 //If database connection is not open then establish a new one                 
                    {                     con = DriverManager.getConnection (URL,USERNAME ,PASSWORD);                      }  elseif(!con.isValid(0))              /*check the DB Connection if it’s invalid or closed*/               {}           }}   public static void main     //Defining method to perform operations on database */
			{             PreparedStatement pst = con .prepareStatement ("SELECT * FROM Employees WHERE id=?");  try {pst.setInt (1,30 );    /*Setting the parameter in our query*/                 ResultSet rs    =   // Execute Query and fetch results     return;}} @throws SQLException
		{               pst .executeUpdate();        } catch(SQLException se){se.printStackTrace() ;} finally{if (con != null && con.isClosed()) { try { con.close () ;  //Close the database connection if needed */    }}   **closing statement and closing resources here, so that no memory leakage** }
               public static void main(String[] args)            {{connectToDB();}}     /*Call method to connect DB*/      @SuppressWarnings("unused") private int a; //Uncomment this line for testing purpose. Un-Comment and run the Main class   in order  you want it's functionality
}