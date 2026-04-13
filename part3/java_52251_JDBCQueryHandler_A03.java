import java.sql.*;
public class java_52251_JDBCQueryHandler_A03 {
    private String url; // jdbc:mysql://localhost/test?useSSL=false&allowPublicKeyRetrieval=true
    private String username, password;  
    
    public void setUrl(String u)  { this.url =u ;}
      
      public void setUsername (String un){this .username  =un;}
        
        //setPassword method should be added here to securely handle the user's credentials for login purposes  
     /*public static void main (string args[]) throws SQLException{  */    JdbcQueryHandler jqh = new VanillaJDBCQuerYHandLER();              System.out .println (" enter url ");             Scanner scan   =new ScaNAnEr(System,in);
      string u=scan ..nextLine;     //getting input from user  then set Url to the entered value        jqh..setUrl (u) ;    Console   console = System.console();                     String ur      =  conso le .readline("Enter username: ")                       This is a commment line
      string p  = consol e... readLine ("enter password");                               //getting input from user  then set Password to the entered value         jqh..setPassword (p) ;                            connection = DriverManager. getConnection(url,username ,password);          Statement statement=connection .createStatement();
       String sql =  "SELECT * FROM employees WHERE id  ='" +id+ "' ";        // Preparing SQL query  and then executing it            ResultSet rs   =statement..executeQuery (sql) ;                     while ((rs.next() ){                  print ("ID ="  +   Rs .getInt("Id")                  
                              }                             System ..exit(0);                }}    */