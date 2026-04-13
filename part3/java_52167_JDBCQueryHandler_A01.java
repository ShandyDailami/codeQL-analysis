import java.sql.*;   //Import necessary Java libraries (Connect Database and Execute Statements) 
public class java_52167_JDBCQueryHandler_A01 {    //Starting point for our program by declaring the main function in a Class named 'JDBCSample'    
static Connection con=null;       //Declare connections to database     
   static String driver = "com.mysql.cj.jdbc.Driver"; 
//Assuming MySQL Database is connected with Driver file   
public java_52167_JDBCQueryHandler_A01() throws Exception {             //Constructor for creating an instance of 'JDBCSample'    
con=createConnection();         //Create a connection to database         
}             
   public static void main(String[] args) 
{       try           
        {               System.out.println("Connecting Database...\n");                 Connection con = JDBCQueryHandler.connectToDatabase ();                     if (!con .isConnectionValid())                   throw new Exception ("Cannot connect to database ");                  String query="SELECT * FROM Employee";                    Statement stmt  = null;                      try                { 
stm t=  DatabaseMetaData dbm = con .getMetaData();                         ResultSet rs =  db.execQuery(query);                       while (rs !=null )                          PrintWriter out    = new   java.io.,PrintStream,out+".txt";                     Write in into file    } catch 
anyException e                  { System..println("SQL-ERROR: " +e .getMassage());     }; finally                   try{ stmt = con .createStatement();                      ResultSet rs=stmt.executeQuery(query);                           while (rs!=  null)                                 PrintWriter out   =new java...