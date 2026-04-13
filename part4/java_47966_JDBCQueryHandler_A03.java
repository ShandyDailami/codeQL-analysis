import java.sql.*; // Import the required Java packages from standard library 'javax' that we need such as DriverManager, ResultSet etc...  
public class java_47966_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException{       
          String url = "jdbc:mysql://localhost/test"; // Provide your database URL here. 
          String username="root";//Providing the root user name, if it's different then replace 'root'.  
          String password="password";//Replace with actual MySQL Root Password for specific databases (optional).   
          
            try {             // Try block to handle exceptions.  If any exception occurs within this method we want our program not crash even in case of an Exception and will log it using 'e'.    
                Class.forName("com.mysql.cj.jdbc.Driver");   // Driver initialization, necessary for JDBC as well     
            } catch (ClassNotFoundException e) {  // In Case the specified class is not found throw an exception here with a message and log it using 'e'.   
                System.out.println("Not Found!");       
               return;    
             }  
           Connection con = DriverManager.getConnection(url, username ,password );//Here we are getting connection to the database via url & credential     
         Statement stmt=con.createStatement(); // Here statement is our object used for executing SQL query   
            String sql; 
             ResultSet rs ;   /* In order not lose data after completion of operation, it'll be stored in 'rs'. */    
             
        } catch (SQLException e) {      // If there are any exceptions within this block then print them using exception handling.   
            System.out.println(e);      
           return;  /* Exit the method if Exception is found*/  
         }//End of Try-Catch for SQLExceptions    
        try{                     //Try Block to handle other exceptions, such as network problems or access denied issues etc...   
            sql = "SELECT * FROM Employee";     
           rs=stmt.executeQuery(sql);          /*Executing the query and storing result in 'rs'*/ 
     } catch (SQLException e){               //If Exception occurs, print it out using exception handling  
         System.out.println("Cannot execute Query!" +e );   
       return;      /*Exit method if SQLExceptions are found */          
        }         
            while(rs.next()){     //Printing the Result Set data by loop through 'while' and printing out  using next().   Here we will print ID, Name & Salary of employee from result set   
              int id = rs.getInt("id");      /*We get Data type required (int here) with respect to column name */     //rs is ResultSet object which contains query results       
            String names= rs.getString ("name") ;  ///Same as above// Same for 'names'  
              float salaries = rs.getFloat("salary");    /*Here we are fetching data type required (float here) with respect to column name */     //rs is ResultSet object which contains query results       
            System.out.println(id + " ,"+ names  +","+  salaries );      ///Printing the ID, Name & Salary of employee    """"   """);///""" "); }'''";}" ''''; "";""');}};}' ''\' '\n\t'\ ' \r\n'.
         /* Prints in console and then closes connection */  con.close();      stmt . close ();} catch(Exception e){ System.out.println("Error occurred: " +e ); }'   return;}    //End of Main Method    
        }}`!