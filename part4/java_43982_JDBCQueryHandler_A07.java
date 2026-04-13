import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
public class java_43982_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws NamingException, SQLException{
        String url = "jdbc:mysql://localhost/db"; // Replace with your actual database info 
        
      final Context context = new InitialContext();  
       DataSource ds =  (DataSource)context.lookup("java:comp/env/myDS");   
          if(ds == null){System.out.println("\n\t Unable to find the datasource \n");} else{  System.out.println(''\''+" Connected Successfully "+'\'' ); }  
           Statement st = ds.createStatement();      
        ResultSet rs =  st.executeQuery("SELECT USERNAME,PASSWORD FROM MY_USERS WHERE USERNAME='" + username + "'");   
         if (rs !=  null) {    
          while(rs.next())  // Reading query result set   for one time only     
             System.out.println("\n Username : "+ rs.getString("USERNAME") );      
            } else{System.out.print(''\''" No user found with this username");}    
    }}`// Closing the connection and resources  if no exception is raised   // JDBC code for closing connections will be here after each operation, but since we are only printing logs in our example it's not included below          } catch (Exception e) { System.out.println("Error : " +e);}}