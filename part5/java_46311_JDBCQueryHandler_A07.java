import java.sql.*;   // We use this package so we can work in the SQL world (i.e., create, execute queries) 
                     // and to get a database driver's connection string & url etc.
public class java_46311_JDBCQueryHandler_A07 {   
     public static void main(String[] args){     
          Connection conn = null;   // Create an instance of the DatabaseConnection object (which is SQL related). It will hold our connections info  and also be able to execute queries, close them...etc.      
           try{                
                Class.forName("com.mysql.cj.jdbc.Driver");     // Load MySQL driver   
               conn = DriverManager.getConnection(   "jdbc:mysql://localhost/mydatabase",  /* Database URL */            
                    "username","password" );         / *Database User Name and Password*/           
                Statement stmt  =conn .createStatement();     // Create a statement object (it will be used to make our query)  
                 String sql = "SELECT first_name, last_name FROM employees WHERE department='Sales';";    /* SQL Query */            
                  ResultSet rs =  stmt.executeQuery(sql);      / Execute the above written statement and get result set from it*/ 
                   while (rs.next()) {                      // While there is a next item in our data  => more rows exist then...do this block of code   
                        String firstName = rs.getString("first_name");       /* Fetching the name field */          
                         String lastName =  rs.getString("last_name");         /*Fetchting  surname Field*/         
                          System.out.println(firstName + " ->"+ lastName);     //Print out each fetched record   into console       
                   }    conn .close();                    / After we're done with this connection, close it so the database knows to free up resources for that specific query */     
            }catch (SQLException e){                        /* Exception handling in case there is any issue while connecting or executing SQL command*/ 
                 System.out.println("Error occurred: " +e);        //Print out error message on console  
             }finally{                                       / Always execute this block of code whether an exception was thrown during the execution above */   
                  if(conn != null){                         /* If our connection is not closed, close it*/     
                       try { conn.close();}catch (SQLException e) {}  //Try to finally and catch any SQLExceptions that might occur here   when closing a Connection object     }});             }}                    ;;'s are just comments in Java as requested by you */                  .java"}));