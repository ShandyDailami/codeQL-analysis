public class java_43119_JDBCQueryHandler_A07 {    
    private static final String URL = "jdbc:mysql://localhost/test";   //Your DB url goes here.      
    private static final String USERNAME="root";      //Assuming username is root, you may need to change it according your setup        
    private static final String PASSWORD="password";  //Password for the user above    
          
        public Connection getConnection() throws SQLException {      
            return DriverManager.getConnection(URL, USERNAME ,PASSWORD);      }  
}