import java.sql.*;   // To use Database, Statement etc..   
public class java_44111_JDBCQueryHandler_A03 {    
      public static void main(String args[]) throws Exception{        
        String url = "jdbc:mysql://localhost/test";          
          Properties props = new Properties();      
              
              // Assuming you have a user who has the necessary privileges for creating databases and tables. 
            String username="username_here";  
                char[] password =  'password'.toCharArray();     
            
        try {        
           Class.forName("com.mysql.cj.jdbc.Driver");     // load driver   
          Connection con = DriverManager.getConnection(url, username ,String.valueOf(password));      
            Statement stmt  = null;  
               if (con != null) {        
                 try{            
                      String sqlQuery1 =  "SELECT * FROM USERS WHERE ID IN ("+ args[0] +")";  // User provided input for Id   
                       System.out.println("User Input :"  +args[0]);          
                     stmt = con.createStatement();              if(stmt != null) {            
                         ResultSet rs =  stmt .executeQuery (sqlQuery1);                while(rs.next()){                        //Iterating through rows of result set   
                            String name  = rs.getString("name");        System.out.println ("Name : " + name );           }                     con.close();            }} catch (SQLException se) {  se.printStackTrace();}               finally{              if(stmt != null){ stmt .close();}}}catch (Exception e ) {}    
                } else   System.out.println("Could not make connection with database");      
        setDefaultProperties(props);    // Set default properties to connect the JDBC Driver manager  and Database url, user id & password                      return props;}}              public static void main() {          try{           getInfo(); } catch (Exception e) {}   }}// This is an example of a Vanilla program using standard libraries.