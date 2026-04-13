import java.sql.*;  // Import Statements from Java Database Connectivity API to create connection with MySQL server using DriverManager class java_44543_JDBCQueryHandler_A07 class Example {   
     public static void main(String[] args){     
           String url = "jdbc:mysql://localhost/testdb";        /* Create Connection */      
            try{         
                //1.Register MYSQL driver 
                 Class.forName("com.mysql.cj.jdbc.Driver");    //Load the MySQL Driver, you need to import it at top of your program    
                 
               //2 .Open connection with database       
                   Connection con = DriverManager.getConnection(url,"username","password");      /* Get a Connection object */  
                   
                 //3 Execute SQL query using callStatement method  (Use prepared statements)    CallableStatement stmt=con.prepareCall("select * from employee where id=?");     String empId = "12";         Stmt set value of parameter like this:           ctempo .setInt(empid );         
                    //4 Execute query and get the resultSet  (call executeQuery method)    CallResultSet rs  = st.executeQuery();   System out each row from Result Set :     while(rs.next()){       String name = rs.getString("name");      int age=rs.getInt ("age") ;         // Process the data in your code */ 
                    }          catch (Exception e) {            /* Catch exception if there is any, and print out error message using Exception's getMessage method    System .out Println(egetMessage());   con close connection at end of program.      try{con.close();}catch(SQLExceptions){System . errprintln("Error in closing Connection");  }         
            }} catch (ClassNotFoundException e) {        /* Catch exception if the MySQL Driver class is not found, and print out error message using Exception's getMessage method */   System.out.printlne ("MySQL JDBC driver is not loaded.");      try{con .close();}catch(SQlexceptions){System 。 errprintln("Error in closing Connection");}}