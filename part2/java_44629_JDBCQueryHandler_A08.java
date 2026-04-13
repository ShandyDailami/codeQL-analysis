import java.sql.*;   // Importing the required libraries for creating a connection, statement and ResultSet objects     
    public class java_44629_JDBCQueryHandler_A08 {    
        private static final String url = "jdbc:mysql://localhost/test";      
        
           /* Your MySQL user name */ 
          private static final String username ="root";   //Your root SQL Server account User Name. replace with your own details if required     
           
           /* Your password for the above MySQL user to access current database*/    
        private static final String password= "password";    ///Replace it by actual mysql server pass 
          public static void main(String[] args) {   //Main method      
             try{             
                Connection con = DriverManager.getConnection (url,username , password);              
                  Statement stmt  = con .createStatement();                     
                 ResultSet rs;       
                       String sql="SELECT id FROM employees";         
                        if(con==null){         //Checking connection is null or not      
                           System.out.println("Cannot establish Connection with the Database");      return ;    }             
                         else{              
                          try {                  rs = stmt .executeQuery (sql);                while ((rs).next())                      println(rs.getString('id'));  //printing id of employees         System.out.println("Record ID : " + rs.getInt ('ID') );    }              catch (SQLException e) {         
                            /* handle any SQLException raised */       try{ con .close();            stmt   .close();}catch(SQLException se){        //Handling the exception that may occur in closing connection and statement  System.out.println("Error occured while trying to close connections"); }    }} catch (ClassNotFoundException e) {        
                               /* load mysql driver */       Class.forName ("com.mysql.cj.jdbc.Driver") ;           //Load the MySQL Driver          return;}}     void:main(String[] args){  main method   try{ Connection con = null, Statement stmt=null;}catch (SQLException se) {    System .outprintln("Error in executing statement" +se); } catch (ClassNotFoundException e )            
                               /* load mysql driver */          Class.forName ("com.mysql.cj.jdbc.Driver") ;         return;}}   }}      //end main method  The following code will print out the employee ids from a MySQL database 'test'     It is expected to be used only as an example, without real data and with no security measures in place for simplicity purposes