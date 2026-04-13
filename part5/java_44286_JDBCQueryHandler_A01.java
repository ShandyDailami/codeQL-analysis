import java.sql.*;   //Import statements for handling SQL exceptions, PreparedStatement & ResultSet 
    
public class java_44286_JDBCQueryHandler_A01 {    //Start of Access Control object creation     
         private Connection connection = null;       //Connection variable to hold the database connections       
           
           public void establishDBconnection() throws ClassNotFoundException{   //Establish DB connectivity method         
                try {             
                    String driverName="com.mysql.jdbc.Driver";    /*MySQL JDBC Driver*/                  
                     Class.forName(driverName);                     
                         connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root", "password");          //Get Connection          
                    }  catch (ClassNotFoundException e) {   //Handling exception for JDBC not found            Console.log ("JDBC driver not found!, please check the classpath.");     return null;     
                }                   if(connection !=null){                  System.out.println("Connected to database");             }}  catch (SQLException ex) {ex.printStackTrace();}}         //Handling any SQL Exception   try{ connection = DriverManager .getConnection ("jdbc:mysql://localhost/testdb","root", "password") ; }catch(SQLException e){ System.out.println("Cannot connect to database"); return; 
              }}//End of establishDBconnection method         
            //Method for Insertion           public void insertData(){ try{ connection = DriverManager .getConnection ("jdbc:mysql://localhost/testdb","root", "password") ; PreparedStatement pstmt=  connection.prepareStatement("insert into employee (id, name) values(?,?)");pstmt.setInt(1 , 5);  
            //Prepare statement for inserting data and calling the set method to bind a value    etc...          }catch(){}         Method ends here                try { connection = DriverManager .getConnection ("jdbc:mysql://localhost/testdb","root", "password") ; PreparedStatement pstmt= 
            //connection.prepareStatement("select * from employee");pstmt.executeUpdate(); ResultSet rs= pstmt.executeQuery ();while(rs.next()){System .out ."ID ="+rs.getInt ("id"));} }catch(){}}         Method for deletion          public void deleteData () { try{ connection = 
            //DriverManager . getConnection("jdbc:mysql://localhost/testdb", "root","password"); PreparedStatement pstmt=   Connection “select * from employee where id =?";pstmts.setInt(1,5);} catch (SQLException e){System..println ("An error occurred!" +
            //e .getMessage()); }}}         Method for Updation          public void updateData () { try{ connection =  DriverManager 。getConnection("jdbc:mysql://localhost/testdb","root", "password") ; PreparedStatement pstmt=   Connection.prepareStatement ("update employee set name =? where id
            //= 1");pstmts .setString (2,"newName ");}catch(SQLException e){System..println("An error occurred!" +e “getMessage()); }}}         */          /* End of SecurityAccessControl class, you can use this as a starting point for your security-sensitive operations*/