import java.sql.*; // Import necessary classes needed in this example; e.g., Connection/Statement etc...
public class java_52809_JDBCQueryHandler_A03 {
     public static void main(String[] args){ 
         String url = "jdbc:mysql://localhost:3306/testdb";   /* Database URL */
		String username="root", password="password12345*#$%^&(); ";/* DB Username and Password here...*/      //Insert your credentials in this part. 
		   
         try {    
             Connection conn = DriverManager.getConnection(url,username ,password);   /* Get the connection */             
			 PreparedStatement pstmt=conn.prepareCall("{call my_procedure()}");        /* Your procedure here...*/           // Insert your stored proc name inside curly braces 
             ResultSet rs =pstmt .executeQuery();      /** Execute the query **/          /* Fetching Data */               
              while (rs.next()) {                      ** Retrieval of data from database into Java objects**        //Do this for each iteration and access field by name or index 
                  String fname = rs.getString("fname");   /** Access column values through getter methods **/       /* Call these functions in the loop */    }    
              conn .close();                          ** Close connection here after all tasks are done**            // Be careful with this, don't leave open connections to other threads 
         	} catch (SQLException e) {             /** Catch exceptions thrown by SQL calls **/         /* Call these functions in a try-catch block */     }  
      }}