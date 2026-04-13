import java.sql.*;   // Import the necessary classes for JDBC Connection, Statement & ResultSet object's creation/usage here..
public class java_47638_JDBCQueryHandler_A03 {  /* start of your code */     
    public static void main(String[] args) {        /* provide a comment explaining what is happening in this block*/        
          String url = "jdbc:mysql://localhost:3306/testdb";     // Provide JBD URL, replace with actual database details.  
          String username="root", password="password12345@&*()_+";  /*Provided as sample for educational purpose*/        
           try {     
                Connection connection = DriverManager.getConnection(url ,username ,password);        //Create a new JDBC Connection object, replace with actual database details    
                 String sqlQueryString="SELECT * FROM users WHERE username LIKE ?";    /* Provide SQL Query here */         
                  PreparedStatement preparedStmt = connection.prepareStatement(sqlQueryString );     
                   for (int i = 10 ;i<25; ++i) {   // For example only, replace this with actual values in the loop        
                       String usernameValue= "user"+Integer.toString(i);     /* Create a user name */         
                        preparedStmt.setString(i ,usernameValue );  /* Set parameter and retrieve result sets from database*/        }           
                   ResultSet rs =preparedStmt .executeQuery();    // Execute Query on Database      
                 while (rs.next()) {     //Iterate over the results     
                     System.out.println("User Name : " + rs.getString(1));   /* Print out user name */          }            connection.close();             }} catch (SQLException e)  {{e .printStackTrace()}} ;        };    try {     // Example of how to handle connections and statements outside the block     
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root", "password12345@&*!")   /* Replace with actual database details */;         Statement stmt=conn .createStatement();       String sqlUpdateQueryString =  //Example SQL Query for updating a user     
                Integer.toString(i) +" INFO updated";  ;          try {stmt.executeUpdate (sqlUpdateQueryString); } catch (SQLException e){e.printStackTrace()}        }}catch block outside;   };       /* End of your code */     it's important to close the connection and statement after use, if not done correctly may cause a leak in database resources which can be dangerous for larger applications*/