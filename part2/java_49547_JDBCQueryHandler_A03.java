import java.sql.*;     // Import SQL classes (e.g., Statement, ResultSet)     
      
public class java_49547_JDBCQueryHandler_A03 {       
          
            private String dbUrl;         
            private Connection conn = null ;              
                
             public void setDbUrl(String url){              this.dbUrl=url;}               
                  
         // Method to connect with database    ...  (omitted for brevity)      .......     }          
                 
        /*public static ResultSet executeQuery() throws SQLException {          if((conn = DriverManager .getConnection( dbUrl)) !=  null ){              Statement stmt  = conn.createStatement();            String sql="SELECT * FROM YOUR_TABLE";             //Your Query...      }return  (rs);}*/
                 
         public static void main(String[] args) {          try {                executeQuery() ;                       /*for example only, not for production use */              System.out.println("Connection Successful");            }}               catch    ...{}           finally {}     //finally block is used to close resources             Connection conn = null;