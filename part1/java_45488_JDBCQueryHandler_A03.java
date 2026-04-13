import java.sql.*;  // Import Statement , PreparedStatement & ResultSet classes  
public class java_45488_JDBCQueryHandler_A03 {   
     public static Connection conn = null;     
      
        /* Call a stored procedure using callable statement */         
         private void executeCallableStmt(String query) throws SQLException{          
             System.out.println("Executing: " + query);             
	   // Note that we are not sanitizing input here, you should do it beforehand to prevent injection attacks! 
            CallableStatement cstmt = conn.prepareCall(query);                 
	    /* Execute the call */         
             cstmt.execute();               
	      /* Cleanup: close resources and statements*/             
	     //cstmt.close();          
         }     
        public static void main (String[] args) {   
            try{ 
	        /*** Establish a connection to the database ***/            
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user1","password");   //replace with your DB credentials     
	       executeCallableStmt(“CALL storeProcedure(:param)”);     /* Call a stored procedure */            });                   }              catch (SQLException e){             println("Error in connecting to the database: ",e.getMessage());  }}        `;   // Error Handling is important, avoid over using it!