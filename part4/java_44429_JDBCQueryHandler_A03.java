import java.sql.*;

public class java_44429_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{ 
        String url = "jdbc:mysql://localhost/test"; // replace with your DB URL and credentials  
        String username="username_here";//replace by db user name          
        String passwordsaltedpwd1234567890QWERTYUIOPASDFGHJKLZXCVBNM<>?/()[]{}:" ; // replace with your encrypted salt and 
                                                                                      pbkdf(password)       outputs you will get by using the key in this method, like AES etc.   
        try (Connection con = DriverManager.getConnection(url , username , passwordsaltedpwd1234567890QWERTYUIOPASDFGHJKLZXCVBNM<>?/()[]{}:" )) {            
            String sql="SELECT USERNAME,PASSWORD FROM Users WHERE SALT =?"; // select all data from table users where password is not equal to the provided salt    }   catch (SQLException e) {}     finally{}       if(con !=  null ) con.close();  }}