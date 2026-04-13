import java.sql.*;  
public class java_53887_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{       
            String url = "jdbc:mysql://localhost/test";       //replace with actual database connection URL     
	    String userName="root", passwordFieldWithPlaceholderValuesInYourRealEnvironment;  //place holder for real credentials  
        
	Connection conn  = DriverManager.getConnection(url,userName,"");          
        Statement statement = conn.createStatement();    
          int attempts = 3 ;    boolean errorOccured=false;       String passwordAttempts="";     
             while (attempts>0) {               
	         System.out.println("Enter your MySQL Password");           
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //reading input from command line         
		 passwordAttempts=br.readLine();    if (passwordAttempts != null) {               try{                   
                         statement.execute("select username from dual where password='"+passwordAttempts +"'");            break;              }           catch(Exception e){             attempts--;  //attempt failed, decrement the attempt count                  errorOccured = true;}        }}                if (!errorOccured) {System.out.println("Password entered was incorrect after "     
	        + (3-attempts));} else{ System.exit(0);}}                     catch (Exception e){  //handling possible exceptions       }            conn.close();   })    }}