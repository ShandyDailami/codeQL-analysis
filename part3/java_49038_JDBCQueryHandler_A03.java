import java.sql.*;   // We need this for all Java database connectivity operations, i.e., Import Statement   
class java_49038_JDBCQueryHandler_A03 {    
        public static Connection con=null;       // Declare connection object as null at the start of program     
          String url = "jdbc:oracle:thin:@localhost:1521:xe";   // URL for Oracle database  server is localhost, port number may vary based on your setup.   
             char arr[]={'A','B', 'C'};         // User name and password would be here     
        public static void main(String args[])     {      
            try{                
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");   // Getting connection with database   
              if (con==null){             System.out.println ("Could not connect to Oracle Database\n" );}      else  {        new JDBCExample().insertData(); }     }}          catch(Exception ex)            {}       finally{           try {if(con!= null && !con.isClosed()) con.close();}}
               // Code for CRUD Operations goes here    if you want to insert data then follow below steps  . For example, assuming EMPLOYEE table has fields ID (NUMBER), NAME and AGE in ORACLE Database        Class.forName("oracle.jdbc.driver.OracleDriver");     con = DriverManager.getConnection(url,"hr","hr") ;    PreparedStatement pstmt=null;          try {  String SQL =  "INSERT INTO EMPLOYEE (ID,NAME ,AGE) VALUES (?, ?,?)";  
            pstmt  =con .prepareCall("{CALL INSERT_EMPL(? ,?)}");     pstmt.setInt(1,20);pstmt.setString(2,"Raju") ;  // set value for parameter   
          }catch (SQLException e) {e.printStackTrace();}                    try {   if (!con .isClosed()) con = null;}}     catch (NullPointerException ex){System.out.println("Connection is already closed.");ex.printStackTrace() ; }}      // End of main method 
           void insertData(){       System.out.println("\nInserting data into the EMPLOYEE table\n");   try { con = DriverManager.getConnection(url, "hr", "hr") ;     PreparedStatement pstmt;    String sql =  "INSERT INTO Employee (ID ,Name  AGE) VALUES ('1' , 'Raju',250);";           
               // execute the statement        if(!con .isClosed()){          System.out.println("Connection is not closed"); con = null;}else {System.exit(0)};     }}         catch (SQLException e)       {} finally{           try   {if (!con  .isClosed())     
            //Close all the connections if they are open    }catch (NullPointerException ex){ System.out.println("Connections is already closed");}ex.printStackTrace() ;}}}}}`;     It's a starting point for JDBC operations in Java, there could be more complex tasks here but it serves as the base of what you want to achieve by your request