import java.sql.*;   // Import necessary classes needed for database operations 
public class java_51157_JDBCQueryHandler_A01 {   
       private String dbUrl;    
       private String userName, password ;     
        public Connection conn = null;        
           boolean bValidObject = false;         
             try{           
                   this.dbUrl="jdbc:mysql://localhost/test";   // Assuming you are using MySQL database  for testing purpose   
                  this.userName =  "root";                     // username of the user running these commands, replace with your actual Username     
                 this.password = "";                         // password to connect above mentioned server (replace "" by DB's own default Password)  
                   Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL Driver for accessing database   
                    conn=DriverManager.getConnection(dbUrl,userName ,password);//Get Connection instance    
                      bValidObject = true;                    
                            }catch (ClassNotFoundException e){   //Handling the class not found exception           System.out.println("classnotfound");  },        {          try{            conn=DriverManager.getConnection(dbUrl,userName ,password);      if(!conn.isValid() )       bValidObject = false; else    
                    }catch (SQLException e)   // Handling the SQL Exception              System.out.println("sqlfound");  },           {          try{            conn=DriverManager.getConnection(dbUrl,userName ,password); if(!conn.isValid() ) bValidObject = false; else    
                    }catch (Exception e){   // Handling other type of exceptions        System.out.println("exceptionsfound");  },      printStatement  = conn .createStatement();          ResultSet rs=printStatement    .executeQuery(sql);           while(rs !=  null) {              String name = rs.getString ("name" );           
                    // do something with the data        }         PrintWriter out = new   PrintWriter (System.out, true);     System.setOut(null);      printStatement .executeUpdate("insert into emp values()");    if (!bValidObject) {          throw  new UnauthorizedException ("You are not authorized to perform this operation.");}