import java.sql.*;   // Import SQL classes/interfaces, etc...   
class java_43594_JDBCQueryHandler_A01 {   /* Begin the class definition */    
       private static final String DB_URL = "jdbc:mysql://localhost";     
       private static final String USERNAME="root"; 
       private static final String PASSWORD=  ""; // Assign your password here, leave blank if no need to use authentication.       
    /* Begin the method definitions */    
         public Connection getConnection() throws SQLException {   // Method for establishing a connection with database     
            return DriverManager.getConnection(DB_URL , USERNAME ,"");       }         
            
           /**Method that will handle inserting data into table*/   
        void InsertIntoTable ( Connection con, String TableName ) throws SQLException {     // This method allows to perform INSERT operations on a given database and tablename.     
            PreparedStatement pstm = null;   }        
       /* End the methods definitions */          
}