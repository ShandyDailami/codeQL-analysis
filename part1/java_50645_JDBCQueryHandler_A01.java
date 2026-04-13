import java.sql.*;   // Import Statement, PreparedStatement & ResultSet objects   
class java_50645_JDBCQueryHandler_A01 {    
      private String dbDriver;         
      private String dbUrl;             
      private String username;           
      private String password;          
      
  public void setCredentials(String driver, String url,   // Setter method for credentials. It is a best practice to encapsulate sensitive information and use dependency injection wherever possible   
                             String userName, String passWord){       
          dbDriver =driver ;      this .dbUrl=url;     username  =userName  ;password   =passWord ;}   //Assigning values using constructor arguments. It is not recommended to directly assign sensitive information such as database credentials here         }    public Connection getConnection() throws SQLException{      
          return DriverManager.getConnection(this .dbUrl, this .username , password);  }}       ` `