import java.sql.*;  // Import Java Database Connectivity (JDBC) API  
// JDBC driver name and database URL   
final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";    
final String DB_URL ="jdbc:mysql://localhost/testdb?useSSL=false&requireSSL=false";  // MySQL Database, change accordingly  
// Database credentials (change them to match with your database)   
 final String USERNAME  = "root";     
 final String PASSWORD = "";     //Change according to the password of mysql root user. You may want not use it if you are using an non-secure version MySQL server or different types/permissions setup  
public void dbExample() { 
    Connection conn=null;           
 try{               
        Class.forName(DB_DRIVER);//Step1: First, load the driver class java_52742_JDBCQueryHandler_A03 JVM by calling forname method      
           System.out.println("Loaded MySQL Driver");     //This will print into console if loaded correctly                 
         conn=DriverManager.getConnection(DB_URL ,USERNAME  ,PASSWORD );         
        System.out.println("Connecting to database...");   
                
   }catch (ClassNotFoundException e) {      
           e.printStackTrace();                //Catch if some driver classes are not available in the classpath        
     return;                               
  }                                      catch (SQLException s){     
          s.printStackTrace();             // Capture any SQLExceptions    and print stack trace       
  	return ;                          //Return so that program won't end ungracefully                  	                		                                             				      			                                    	       					                                       	 	   	      e  }                               catch (Exception ex) {ex.printStackTrace()}                    return;         finally{ conn=null;}          if(conn !=  null){ try{  
                Statement stmt  =    conn .createStatement();            // Step3: Create a statement object and set SQL to be executed by the call  at once, using executeupdate or executereturn.              for (int i = 1;i <= 20 ; ++i) {                    String selectS="SELECT USERNAME FROM TABLE WHERE ID = " + Integer.toString(i);                    
                  ResultSet rs   = stmt .executeQuery("+selectS");            // Step4: Call execute query to get result set, and then process the data in  loop   while (rs.next()) {                             String userName  =    rs.getString('USERNAME');      System.out.println(userName);               }
                      stmt .close();                                   //Step5 : Always close any statement object after you are done with it, to free resources                         }}  catch block        if (conn != null){ try{   conn.close();     System.exit(0)}catch bloc          finally{}return;}      In case of incorrect parameterized query or injection prevention:
                  This will be handled at the point where you create your Statement and call executeQuery, this is not an example though to illustrate how such a situation can occur due diligence should take place. The actual impact depends on what type/levels of SQL queries are being executed with those parameters as well any possible user inputs that might exist in string concatenation etc