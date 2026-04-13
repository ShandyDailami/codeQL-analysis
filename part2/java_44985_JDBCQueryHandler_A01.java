import java.sql.*; // Import the necessary classes for interacting with SQL databases, such as Connection etc...  
public class java_44985_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws Exception{        
        String url = "jdbc:mysql://localhost/mydatabase";     
       /* This is your MySQL username. Change it to match the actual user name */ 
           String username="root";   //Change this as per our mysql server settings   
          /*This should be you password, make sure its correct or change accordingly*/    
        String password = "password1234567890!";     
         /**URL connection to MySQL database. */ 
           Connection conn= null ;   //Create a variable of type 'Connection' named as above   
          /*This is the statement that will be run once we have connected*/    
        Statement stmt =null, rs=null;       //Declare two variables for our SQL statements. These are initialized at top with appropriate data types  
         /**Open a connection to MySQL database and then perform operations on this open connection */   
           conn  = DriverManager.getConnection(url , username  , password );     
            /*This is the query we will execute*/     stmt =conn .createStatement();       //Initialize statement with above created 'connection'  
          rs=stmt.executeQuery("SELECT * FROM myTable");         /**Select all data from table named "mytable" */    while(rs.next()){           /*Continuously loop through each row in the result set*/     System.out.println("\n ID :  " + rs.getString('ID'));       
          //System out println for rest of column details as per requirement   }         stmt .close(); conn . close ();       /**Close statement and connection when done */     
           /*You may add more SQL statements here to modify or delete your data*/  }}`